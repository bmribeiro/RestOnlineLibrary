package com.codelab.restOnlineLibrary.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codelab.restOnlineLibrary.auth.UserAuthenticationProvider;
import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.LoginDTO;
import com.codelab.restOnlineLibrary.dto.RegisterDTO;
import com.codelab.restOnlineLibrary.services.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private UserAuthenticationProvider userAuthenticationProvider;

	@PostMapping("/login")
	public ResponseEntity<AuthUserDTO> login(@RequestBody @Valid LoginDTO credentialsDto) {
		AuthUserDTO userDto = authService.login(credentialsDto);
		userDto.setToken(userAuthenticationProvider.createToken(userDto));
		return ResponseEntity.ok(userDto);
	}

	@PostMapping("/register")
	public ResponseEntity<AuthUserDTO> register(@RequestBody @Valid RegisterDTO registerDTO) {
		AuthUserDTO createdUser = authService.register(registerDTO);
		createdUser.setToken(userAuthenticationProvider.createToken(createdUser));
		return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
	}

}
