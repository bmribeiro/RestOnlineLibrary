package com.codelab.restOnlineLibrary.auth;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.codelab.restOnlineLibrary.dto.UserDto;

import jakarta.annotation.PostConstruct;

@Component
public class UserAuthenticationProvider {

	@Value("${security.jwt.token.secret-key:secret-key}")
	private String secretKey;
	

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	public String createToken(UserDto user) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3600000);

		// Creates an HMAC signature algorithm
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		
		// Create and sign the JWT token
		return JWT.create().withSubject(user.getLogin()).withIssuedAt(now).withExpiresAt(validity)
				.withClaim("firstName", user.getFirstName()).withClaim("lastName", user.getLastName()).sign(algorithm);
	}

	public Authentication validateToken(String token) {
		
		// HMAC signature algorithm
		Algorithm algorithm = Algorithm.HMAC256(secretKey);

		// JWT checker
		JWTVerifier verifier = JWT.require(algorithm).build();

		// Verifies the token and decodes
		DecodedJWT decoded = verifier.verify(token);

		UserDto user = new UserDto.Builder().setLogin(decoded.getSubject())
				.setFirstName(decoded.getClaim("firstName").asString())
				.setLastName(decoded.getClaim("lastName").asString()).build();

		// Creates and returns an authentication object
		return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
	}
	

}
