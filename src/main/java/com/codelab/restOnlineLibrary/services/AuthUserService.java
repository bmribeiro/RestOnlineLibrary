package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.mappers.AuthMapper;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;

@Service
public class AuthUserService {

	@Autowired
	private AuthUserRepository authUserRepository;

	@Autowired
	private AuthMapper authUserMapper;

	public List<AuthUserDTO> findAll() {
		List<AuthUser> authUsers = authUserRepository.findAll();
		return authUsers.stream().map(authUserMapper::toDTO).collect(Collectors.toList());
	}

}
