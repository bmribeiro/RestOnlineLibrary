package com.codelab.restOnlineLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.services.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/reservations")
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		
		try {
			Reservation reservationEl = reservationService.createReservation(reservation);
			return ResponseEntity.ok(reservationEl);
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping("/reservations/{id}")
	public ResponseEntity<Reservation> updateReservationStatus(@PathVariable Long id, @RequestParam String status) {
		
		try {
			Reservation reservation = reservationService.updateReservationStatus(id, status);
			return ResponseEntity.ok(reservation);
		
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}