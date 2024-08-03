package com.codelab.restOnlineLibrary.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelab.restOnlineLibrary.entities.AuthUser;

public interface AuthRepository extends JpaRepository<AuthUser, Long> {

	Optional<AuthUser> findByEmail(String email);

}
