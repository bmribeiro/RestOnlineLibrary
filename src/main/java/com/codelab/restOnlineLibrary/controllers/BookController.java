package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<List<Book>> findAll() {

		List<Book> books = bookService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(books, headers, HttpStatus.OK);
	}
	
	@GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@PostMapping("/books")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        
        Book savedBook = bookService.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        if (bookService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}