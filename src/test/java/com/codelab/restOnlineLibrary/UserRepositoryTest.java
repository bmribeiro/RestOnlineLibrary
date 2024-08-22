package com.codelab.restOnlineLibrary;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private AuthUserRepository userRepository;

	@Test
	public void testUserRepository() {
		assertNotNull(userRepository, "Not null");
	}
}