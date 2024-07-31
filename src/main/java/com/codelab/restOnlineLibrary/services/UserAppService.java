package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.repositories.UserAppRepository;

@Service
public class UserAppService {

	@Autowired
	private UserAppRepository userAppRepository;

	public List<UserApp> findAll() {
		return userAppRepository.findAll();
	}

	public Optional<UserApp> findById(Long id) {
		return userAppRepository.findById(id);
	}

	public UserApp save(UserApp user) {
		return userAppRepository.save(user);
	}

	public boolean deleteById(Long id) {

		if (userAppRepository.existsById(id)) {
			userAppRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}