package com.codelab.restOnlineLibrary.auth;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.dto.ErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Spring Security's AuthenticationEntryPoint implementation. The purpose of
 * this class is to define how the system should respond when an unauthenticated
 * access attempt is made to a protected resource.
 */

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		// HTTP status of the response to 401 Unauthorized
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		// content type header as JSON
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		// custom error
		ErrorDto errorDto = new ErrorDto("Unauthorized path");

		// Serializes error to JSON and write it to the response output
		OBJECT_MAPPER.writeValue(response.getOutputStream(), errorDto);
	}
}
