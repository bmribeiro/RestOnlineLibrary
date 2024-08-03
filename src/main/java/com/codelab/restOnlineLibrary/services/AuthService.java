package com.codelab.restOnlineLibrary.services;

import java.nio.CharBuffer;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.LoginDTO;
import com.codelab.restOnlineLibrary.dto.RegisterDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.exceptions.AppException;
import com.codelab.restOnlineLibrary.mappers.AuthMapper;
import com.codelab.restOnlineLibrary.repositories.AuthRepository;

@Service
public class AuthService {

	private final AuthRepository authRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthMapper authMapper;

	public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder, AuthMapper authMapper) {
		super();
		this.authRepository = authRepository;
		this.passwordEncoder = passwordEncoder;
		this.authMapper = authMapper;
	}

	public AuthUserDTO login(LoginDTO loginDTO) {
		AuthUser user = authRepository.findByEmail(loginDTO.email())
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

		if (passwordEncoder.matches(CharBuffer.wrap(loginDTO.password()), user.getPassword())) {
			return authMapper.toDTO(user);
		}
		throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);

	}

	public AuthUserDTO register(RegisterDTO registerDTO) {

		Optional<AuthUser> optionalUser = authRepository.findByEmail(registerDTO.email());

		if (optionalUser.isPresent()) {
			throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
		}

		AuthUser user = authMapper.toEntity(registerDTO);
		user.setPassword(passwordEncoder.encode(CharBuffer.wrap(registerDTO.password())));
		user.setProfile("default");
		user.setCreated(LocalDateTime.now());
		user.setActive(true);

		AuthUser savedUser = authRepository.save(user);

		return authMapper.toDTO(savedUser);
	}

	public AuthUserDTO findByLogin(String login) {
		AuthUser user = authRepository.findByEmail(login)
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
		return authMapper.toDTO(user);
	}

}
