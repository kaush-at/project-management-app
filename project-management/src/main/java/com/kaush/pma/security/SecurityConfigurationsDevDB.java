package com.kaush.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration   
@EnableWebSecurity
public class SecurityConfigurationsDevDB extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource datasource;  // spring is smart enough to choose the running database and automatically wired it to here
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(datasource)  
		.usersByUsernameQuery("select username, password, enabled " +
				"from users where username = ?")
		.authoritiesByUsernameQuery("select username, authority "+
				"from authorities where username=?");
		
	}
	
	// in spring if we use password we have to use password encoder()
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	// here we configure authorization using httpSecurity
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()  // only admin has access to create projects
			.antMatchers("/projects/new").hasRole("ADMIN")
			.antMatchers("/employees/new").hasRole("ADMIN")
			.antMatchers("/h2_console/**").permitAll()
			.antMatchers("/").authenticated().and().formLogin();
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
}

