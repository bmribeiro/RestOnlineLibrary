package com.codelab.restOnlineLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.BookDetail;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

}
