package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.services.UserAppService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserAppService userAppService;

	@GetMapping("/users")
	public ResponseEntity<List<UserApp>> getAllUsers() {

		List<UserApp> users = userAppService.getAllUsers();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<List<UserApp>>(users, headers, HttpStatus.OK);
	}
	
	@PostMapping("/users")
    public ResponseEntity<UserApp> saveUser(@RequestBody UserApp user) {
        
		UserApp savedUser = userAppService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(savedUser, headers, HttpStatus.CREATED);
    }

}
