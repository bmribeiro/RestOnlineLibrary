package com.codelab.restOnlineLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.UserInMemory;

@Repository
public interface UserInMemoryRepository extends JpaRepository<UserInMemory, Long> {

}