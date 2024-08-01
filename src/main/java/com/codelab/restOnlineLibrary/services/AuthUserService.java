package com.codelab.restOnlineLibrary.services;

import java.nio.CharBuffer;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.CredentialsDto;
import com.codelab.restOnlineLibrary.dto.SignUpDto;
import com.codelab.restOnlineLibrary.dto.UserDto;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.exceptions.AppException;
import com.codelab.restOnlineLibrary.mappers.AuthUserMapper;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;

@Service
public class AuthUserService {

	private final AuthUserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthUserMapper userMapper;

	public AuthUserService(AuthUserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthUserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
	}

	public UserDto login(CredentialsDto credentialsDto) {
		AuthUser user = userRepository.findByLogin(credentialsDto.login())
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

		if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
			return userMapper.toUserDto(user);
		}
		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);

	}

	public UserDto register(SignUpDto userDto) {
		Optional<AuthUser> optionalUser = userRepository.findByLogin(userDto.login());

		if (optionalUser.isPresent()) {
			throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
		}

		AuthUser user = userMapper.signUpToUser(userDto);
		user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

		AuthUser savedUser = userRepository.save(user);

		return userMapper.toUserDto(savedUser);
	}

	public UserDto findByLogin(String login) {
		AuthUser user = userRepository.findByLogin(login)
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
		return userMapper.toUserDto(user);
	}

}
