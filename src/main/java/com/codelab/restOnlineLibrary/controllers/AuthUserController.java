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

import com.codelab.restOnlineLibrary.dto.AuthUserDTO;
import com.codelab.restOnlineLibrary.dto.BookDTO;
import com.codelab.restOnlineLibrary.services.AuthUserService;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class AuthUserController {

	@Autowired
	private AuthUserService authUserService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/authUsers")
	public ResponseEntity<List<AuthUserDTO>> findAll() {

		List<AuthUserDTO> authUser = authUserService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(authUser, headers, HttpStatus.OK);
	}
	
	@GetMapping("/authUsers/{userId}/books")
    public List<BookDTO> getReservationsByUser(@PathVariable Long userId) {
        return bookService.reservationsByUser(userId);
    }
	


}
