package com.codelab.restOnlineLibrary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.repositories.UserAppRepository;

@Service
public class UserAppService {

	@Autowired
	private UserAppRepository userAppRepository;
	
	public List<UserApp> getAllUsers() {
		return userAppRepository.findAll();
	}
	
	public UserApp saveUser(UserApp user) {
		return userAppRepository.save(user);
	}
}