package com.codelab.restOnlineLibrary.services;

import java.nio.CharBuffer;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.LoginDTO;
import com.codelab.restOnlineLibrary.dto.RegisterDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.exceptions.AppException;
import com.codelab.restOnlineLibrary.mappers.AuthMapper;
import com.codelab.restOnlineLibrary.repositories.AuthRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthService {

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;

	private final AuthRepository authRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthMapper authMapper;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

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

	public AuthUserDTO loginWithToken(String authHeader) {

		try {
			String[] authElements = authHeader.split(" ");
			if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
				throw new AppException("Invalid authorization header format", HttpStatus.BAD_REQUEST);
			}

			// HMAC signature algorithm
			Algorithm algorithm = Algorithm.HMAC256(secretKey);

			// JWT verifier
			JWTVerifier verifier = JWT.require(algorithm).build();

			// Verifies the token and decodes it
			DecodedJWT decoded = verifier.verify(authElements[1]);

			AuthUserDTO authUserDTOreturn = findByLogin(decoded.getSubject());
			authUserDTOreturn.setToken(authHeader);
			
			return authUserDTOreturn;
			
		} catch (Exception e) {
			throw new AppException("Token validation failed", HttpStatus.UNAUTHORIZED);
		}
	}

	public AuthUserDTO findByLogin(String login) {
		AuthUser user = authRepository.findByEmail(login)
				.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
		return authMapper.toDTO(user);
	}

}
