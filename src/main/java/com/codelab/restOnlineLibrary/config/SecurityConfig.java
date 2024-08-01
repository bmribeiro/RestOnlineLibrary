package com.codelab.restOnlineLibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.codelab.restOnlineLibrary.auth.JwtAuthFilter;
import com.codelab.restOnlineLibrary.auth.UserAuthenticationEntryPoint;
import com.codelab.restOnlineLibrary.auth.UserAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
	private final UserAuthenticationProvider userAuthenticationProvider;

	public SecurityConfig(UserAuthenticationEntryPoint userAuthenticationEntryPoint, UserAuthenticationProvider userAuthenticationProvider) {
		this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
		this.userAuthenticationProvider = userAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
		
				.exceptionHandling(customizer -> customizer.authenticationEntryPoint(userAuthenticationEntryPoint))
		
				.addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
				
				.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				.authorizeHttpRequests((requests) -> requests.requestMatchers(HttpMethod.POST, "/login", "/register").permitAll()
						
						.anyRequest().authenticated());

		return http.build();
	}

}
