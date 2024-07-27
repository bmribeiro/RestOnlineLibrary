package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.services.UserAppService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserAppService userAppService;

	@GetMapping
	public List<UserApp> getAllUsers() {
		return userAppService.getAllUsers();
	}

}
