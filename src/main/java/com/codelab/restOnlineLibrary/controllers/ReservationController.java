package com.codelab.restOnlineLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.dto.ReservationDTO;
import com.codelab.restOnlineLibrary.services.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@PostMapping("/reservations")
	public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservation) {

		try {
			ReservationDTO reservationEl = reservationService.createReservation(reservation);
			
			// Booking notification
            simpMessagingTemplate.convertAndSend("/topic/rent", reservationEl);

			return ResponseEntity.ok(reservationEl);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping("/reservations")
	public ResponseEntity<ReservationDTO> updateReservationStatus(@RequestBody ReservationDTO reservation) {

		try {
			ReservationDTO reservationEl = reservationService.updateReservationStatus(reservation);
			
			// Return notification
            simpMessagingTemplate.convertAndSend("/topic/return", reservationEl);

			return ResponseEntity.ok(reservationEl);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}