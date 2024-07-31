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

import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.services.UserAppService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserAppService userAppService;

	@GetMapping("/users")
	public ResponseEntity<List<UserApp>> findAll() {

		List<UserApp> users = userAppService.findAll();

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		return new ResponseEntity<List<UserApp>>(users, headers, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
    public ResponseEntity<UserApp> findById(@PathVariable Long id) {
        return userAppService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@PostMapping("/users")
    public ResponseEntity<UserApp> save(@RequestBody UserApp user) {
        
		UserApp savedUser = userAppService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(savedUser, headers, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/users/{id}")
    public ResponseEntity<UserApp> deleteById(@PathVariable Long id) {
		
        if (userAppService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
