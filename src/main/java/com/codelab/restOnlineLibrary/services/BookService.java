package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public boolean deleteById(Long id) {
		
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}