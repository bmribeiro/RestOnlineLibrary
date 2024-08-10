package com.codelab.restOnlineLibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.mappers.AuthUserMapper;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Service
public class AuthUserService {

	@Autowired
	private AuthUserRepository authUserRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private AuthUserMapper authUserMapper;


}
