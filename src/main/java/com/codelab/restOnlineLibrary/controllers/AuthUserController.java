package com.codelab.restOnlineLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.constants.Constants;
import com.codelab.restOnlineLibrary.dto.views.user.UserRentalDTO;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class AuthUserController {

	@Autowired
	private BookService bookService;


	@GetMapping("/users/{userId}/rentals")
	public ResponseEntity<List<UserRentalDTO>> getBooksRentedByUser(@PathVariable Long userId) {

		List<UserRentalDTO> booksRentedByUser = bookService.getUserBookRentals(userId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);

		if (booksRentedByUser != null && !booksRentedByUser.isEmpty()) {
			return new ResponseEntity<>(booksRentedByUser, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(booksRentedByUser, headers, HttpStatus.NO_CONTENT);
		}
	}

}
