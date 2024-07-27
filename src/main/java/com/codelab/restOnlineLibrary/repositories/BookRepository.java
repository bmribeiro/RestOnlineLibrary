package com.codelab.restOnlineLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}