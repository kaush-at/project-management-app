package com.kaush.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration   
@EnableWebSecurity
public class SecurityConfigurationsDevDB extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource datasource;  // spring is smart enough to choose the running database and automatically wired it to here
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(datasource)  
		.usersByUsernameQuery("select username, password, enabled " +
				"from user_accounts where username = ?")
		.authoritiesByUsernameQuery("select username, role "+
				"from user_accounts where username=?")
		.passwordEncoder(bCryptEncoder);  // this time we create password encoder( BCryptEncoder) using webConfig class
		// because of that  we removed our custom method we use to encrypt password for previous example
		
	}

	// here we configure authorization using httpSecurity
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()  // only admin has access to create projects
			.antMatchers("/projects/new").hasRole("ADMIN")
			.antMatchers("/projects/save").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN")
			.antMatchers("/employees/save").hasRole("ADMIN")
			.antMatchers("/", "/**").permitAll() // ** mean all of the other end points (if we put this line to obove this line the other rules wil not registered)
			//.formLogin().loginPage("/login-page"); // if we need to customize a seperate page we can do it using this
			.and()
			.formLogin();

// these things no need in production it can be hacked (we can discuss how to protect your web from csrf tocken)
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}
	
}
