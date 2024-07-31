package com.codelab.restOnlineLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.UserApp;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

}