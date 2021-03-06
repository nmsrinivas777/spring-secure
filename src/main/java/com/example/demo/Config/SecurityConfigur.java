package com.example.demo.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfigur extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	 
	@Override
	protected  void configure(AuthenticationManagerBuilder auth)  throws Exception{
		auth.userDetailsService(myUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordencoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
}
