package com.TwistWallet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("rohit").password("rohit").roles("USER");
	//auth.inMemoryAuthentication().withUser("bill").password("123456").roles("ADMIN");
	//auth.inMemoryAuthentication().withUser("james").password("123456").roles("SUPERADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/**").access("hasRole('ROLE_ADMIN')").
		antMatchers("/getAllProduct").access("hasRole('ROLE_USER')").
		and().formLogin();
	}*/
	
}
