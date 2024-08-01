package com.codelab.restOnlineLibrary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelab.restOnlineLibrary.entities.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

	Optional<AuthUser> findByLogin(String login);

}
