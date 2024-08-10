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
import com.codelab.restOnlineLibrary.dto.views.book.BookDetailDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserDetailDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserViewDTO;
import com.codelab.restOnlineLibrary.services.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/authUsers")
	public ResponseEntity<List<UserViewDTO>> getAuthUsers() {

		List<UserViewDTO> users = adminService.findAll();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);
		
		return new ResponseEntity<>(users, headers, HttpStatus.OK);
	}

	@GetMapping("/admin/books/{bookId}/detail")
	public ResponseEntity<BookDetailDTO> getBookDetailById(@PathVariable Long bookId) {

		BookDetailDTO bookDetail = adminService.getBookDetailById(bookId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);

		return new ResponseEntity<>(bookDetail, headers, HttpStatus.OK);
	}

	@GetMapping("/admin/authUsers/{userId}/detail")
	public ResponseEntity<UserDetailDTO> getUserDetailById(@PathVariable Long userId) {

		UserDetailDTO userDetail = adminService.getUserDetailById(userId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);

		return new ResponseEntity<>(userDetail, headers, HttpStatus.OK);
	}

}
