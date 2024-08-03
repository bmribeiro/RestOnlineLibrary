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

import com.codelab.restOnlineLibrary.dto.UserInMemoryDTO;
import com.codelab.restOnlineLibrary.services.UserInMemoryService;

@RestController
@RequestMapping("/api")
public class UserInMemoryController {

	@Autowired
	private UserInMemoryService userInMemoryService;

	@GetMapping("/users")
	public ResponseEntity<List<UserInMemoryDTO>> findAll() {

		List<UserInMemoryDTO> users = userInMemoryService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<List<UserInMemoryDTO>>(users, headers, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserInMemoryDTO> findById(@PathVariable Long id) {

		return userInMemoryService.findById(id).map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping("/users")
	public ResponseEntity<UserInMemoryDTO> save(@RequestBody UserInMemoryDTO userDTO) {

		UserInMemoryDTO savedUser = userInMemoryService.save(userDTO);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<>(savedUser, headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserInMemoryDTO> deleteById(@PathVariable Long id) {

		if (userInMemoryService.deleteById(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
