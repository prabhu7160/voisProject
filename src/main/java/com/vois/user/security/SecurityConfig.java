package com.vois.user.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.vois.user.service.impl.UserInfoDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //latest method level security annotation 
public class SecurityConfig {

	protected static final String[] PERMITTED = 
		{
				"/userproject/add",
				"/order/placeOrder",
				"/product/add"
		};
	protected static final String[] AUTHENTICATE = {
			"/userproject/edit/*",
			"/userproject/delete/*",
			"/product/edit/*",
			"/product/delete/*",
			"/userproject/*",
			"/product/*"
	};
	//authentication
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder pass) {
//		UserDetails admin = User.withUsername("prabhu")
//				.password(pass.encode("password"))
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withUsername("pa")
//				.password(pass.encode("password"))
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
//	}
	
	public UserDetailsService userDetailsService() {
		return new UserInfoDetailsService();
	}
	
	//for the authorization
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> 
			auth
			.requestMatchers(PERMITTED).permitAll()
			.requestMatchers(AUTHENTICATE).authenticated()).formLogin();
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}