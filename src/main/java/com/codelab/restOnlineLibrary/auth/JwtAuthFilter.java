package com.codelab.restOnlineLibrary.auth;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {

	private final UserAuthenticationProvider userAuthenticationProvider;

	public JwtAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
		this.userAuthenticationProvider = userAuthenticationProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// HTTP request authorization header
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (header != null) {
			String[] authElements = header.split(" ");

			if (authElements.length == 2 && "Bearer".equals(authElements[0])) {
				try {

					// 	Validates the token and sets authentication in the security context
					SecurityContextHolder.getContext()
							.setAuthentication(userAuthenticationProvider.validateToken(authElements[1]));
					
					
				} catch (RuntimeException e) {
					SecurityContextHolder.clearContext();
					throw e;
				}
			}
		}
		
		// Continue the filter chain
		filterChain.doFilter(request, response);
	}
}