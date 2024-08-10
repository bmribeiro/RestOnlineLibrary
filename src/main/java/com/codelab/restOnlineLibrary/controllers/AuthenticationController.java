package com.codelab.restOnlineLibrary.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.auth.UserAuthenticationProvider;
import com.codelab.restOnlineLibrary.constants.Constants;
import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.LoginDTO;
import com.codelab.restOnlineLibrary.dto.RegisterDTO;
import com.codelab.restOnlineLibrary.services.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {

	private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

	@Autowired
	private AuthService authService;

	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;

	@PostMapping("/login")
	public ResponseEntity<AuthUserDTO> login(@RequestBody @Valid LoginDTO credentialsDto) {
		
		AuthUserDTO userDto = authService.login(credentialsDto);
		userDto.setToken(userAuthenticationProvider.createToken(userDto));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);
		
		return ResponseEntity.ok().headers(headers).body(userDto);
	}

	@PostMapping("/register")
	public ResponseEntity<AuthUserDTO> register(@RequestBody RegisterDTO registerDTO) {
		
		AuthUserDTO createdUser = authService.register(registerDTO);
		createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);
		
		return ResponseEntity.ok().headers(headers).body(createdUser);
	}

	@PostMapping("/validate")
	public ResponseEntity<AuthUserDTO> loginWithValidToken(@RequestHeader("Authorization") String authHeader) {
		
		try {
			// Validate the token
			AuthUserDTO loginWithToken = authService.loginWithToken(authHeader);
			
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);
			
			return ResponseEntity.ok().headers(headers).body(loginWithToken);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
