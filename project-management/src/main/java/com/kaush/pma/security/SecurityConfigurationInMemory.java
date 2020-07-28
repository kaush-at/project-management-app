package com.kaush.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration   // by adding this this class is being registered by the spring loader
//@EnableWebSecurity
//public class SecurityConfigurationInMemory extends WebSecurityConfigurerAdapter{

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// we can use to define authentication mechanism
//		1. hard coded value in-memory option
//		2.JDBC authontication
//		3.ldap authontication
//		4.Spring data JPA
//		
//		auth.inMemoryAuthentication()  // because we are using builder pattern here inside inMemeoryAuthontication we can chai the users using and()
//			.withUser("myuser")
//				.password("pass")  // now spring securtity not gives us a default password(because we have override that feature)
//				.roles("USER")
//			.and()
//			.withUser("test")
//				.password("pass2")
//				.roles("USER")
//			.and()
//			.withUser("managerUser")
//				.password("pass3")
//				.roles("ADMIN");
//
//	}
	
	// in spring if we use password we have to use password encoder()
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();    // commented this because we need to access jdbc authorization
//	}
	
	// here we configure authorization using httpSecurity
//	@Override
//	protected void configure(HttpSecurity http)throws Exception{
//		http.authorizeRequests()  // only admin has access to create projects    // commented this because we need to access jdbc authorization
//			.antMatchers("/projects/new").hasRole("ADMIN")
//			.antMatchers("/employees/new").hasRole("ADMIN")
//			.antMatchers("/").authenticated().and().formLogin();
//	}
//}
