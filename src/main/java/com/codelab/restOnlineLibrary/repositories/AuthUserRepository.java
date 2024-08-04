package com.codelab.restOnlineLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelab.restOnlineLibrary.entities.AuthUser;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

}