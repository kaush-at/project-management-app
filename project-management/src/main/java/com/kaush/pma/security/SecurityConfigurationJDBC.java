//package com.kaush.pma.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration   // by adding this this class is being registered by the spring loader
//@EnableWebSecurity
//public class SecurityConfigurationJDBC extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	DataSource datasource;  // spring is smart enough to choose the running database and automatically wired it to here
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.jdbcAuthentication().dataSource(datasource)  
//			.withDefaultSchema()  // when the application start it is going to create couple of tables(users and authority table to build the database model that we 
//								// need to support our outhorization and authontication rules)
//			.withUser("myuser")
//				.password("pass")  
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
		// using these authontication rules it buid user table as wel as authorities table in out db(it is because withDefaultSchema() function )
		
		//-----------------------------------------------------------------
		// if we need to custom our own (if we have our own userroles tbales and user tables etc)
		// remove above .withdafaultSchema to last role and then add 
		/*
		 * 
		.usersByUsernameQuery("select username, password, enabled " +
				"from users where username = ?")
		.authoritiesByUserNameQuery("select username, authority "+
				"from authorities where username=?");
		 */
		//----------------------------------------------------------------

//	}
//	
//	// in spring if we use password we have to use password encoder()
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	// here we configure authorization using httpSecurity
//	@Override
//	protected void configure(HttpSecurity http)throws Exception{
//		http.authorizeRequests()  // only admin has access to create projects
//			.antMatchers("/projects/new").hasRole("ADMIN")
//			.antMatchers("/employees/new").hasRole("ADMIN")
//			.antMatchers("/h2_console/**").permitAll()
//			.antMatchers("/").authenticated().and().formLogin();
//		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
//	}
//	
//}
