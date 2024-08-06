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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codelab.restOnlineLibrary.dto.book.BookDTO;
import com.codelab.restOnlineLibrary.dto.book.BooksAvailableDTO;
import com.codelab.restOnlineLibrary.dto.book.UserBookRentalDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<BookDTO>> findAll() {

		List<BookDTO> books = bookService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(books, headers, HttpStatus.OK);
	}

	@GetMapping("/books/user-status/{userId}")
	public ResponseEntity<List<BooksAvailableDTO>> getAllBooksWithUserRentalStatus(@PathVariable Long userId) {
		List<BooksAvailableDTO> books = bookService.getAllBooksWithUserRentalStatus(userId);
		return ResponseEntity.ok(books);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<BookDTO> findById(@PathVariable Long id) {

		return bookService.findById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping("/books")
	public ResponseEntity<BookDTO> save(@RequestBody BookDTO bookDTO) {

		BookDTO savedBook = bookService.save(bookDTO);

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

	@GetMapping("/books/rented")
	public ResponseEntity<List<UserBookRentalDTO>> getUserBookRentals(@RequestParam Long userId) {
		
		List<UserBookRentalDTO> rentals = bookService.getUserBookRentals(userId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		
		return new ResponseEntity<>(rentals, headers, HttpStatus.OK);
	}

}