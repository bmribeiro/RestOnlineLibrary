package com.codelab.restOnlineLibrary.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.auth.UserAuthenticationProvider;
import com.codelab.restOnlineLibrary.dto.CredentialsDto;
import com.codelab.restOnlineLibrary.dto.SignUpDto;
import com.codelab.restOnlineLibrary.dto.UserDto;
import com.codelab.restOnlineLibrary.services.AuthUserService;

import jakarta.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	private AuthUserService userService;
	
	@Autowired
	private  UserAuthenticationProvider userAuthenticationProvider;

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
		UserDto userDto = userService.login(credentialsDto);
		userDto.setToken(userAuthenticationProvider.createToken(userDto));
		return ResponseEntity.ok(userDto);
	}

	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
		UserDto createdUser = userService.register(user);
		createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
		return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
	}

}
