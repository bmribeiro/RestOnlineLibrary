package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.constants.Constants;
import com.codelab.restOnlineLibrary.dto.views.book.BookViewDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserRentalDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books/user-status/{userId}")
	public ResponseEntity<List<BookViewDTO>> getAllBooksWithUserRentalStatus(@PathVariable Long userId) {
		List<BookViewDTO> books = bookService.getAllBooksWithUserRentalStatus(userId);
		return ResponseEntity.ok(books);
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
	public ResponseEntity<List<UserRentalDTO>> getUserBookRentals(@RequestParam Long userId) {

		List<UserRentalDTO> rentals = bookService.getUserBookRentals(userId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);

		return new ResponseEntity<>(rentals, headers, HttpStatus.OK);
	}

}