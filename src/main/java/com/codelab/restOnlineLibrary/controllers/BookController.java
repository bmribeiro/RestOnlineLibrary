package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> books = bookService.getAllBooks();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(books, headers, HttpStatus.OK);
	}
	
	@PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        
        Book savedBook = bookService.saveBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }

}