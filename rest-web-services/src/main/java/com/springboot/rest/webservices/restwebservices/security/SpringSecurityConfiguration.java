package com.springboot.rest.webservices.restwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configurable
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				AuthConfig -> AuthConfig.anyRequest().authenticated()
				);
		
		http.httpBasic(withDefaults());
		
		http.csrf().disable();
		
		return http.build();
	}

}
