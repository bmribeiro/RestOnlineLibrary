package com.codelab.restOnlineLibrary.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.ReservationDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.enums.ReservationStatus;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private AuthUserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public ReservationDTO createReservation(ReservationDTO reservationDTO) {

		AuthUser userEl = userRepository.findById(reservationDTO.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
		Book bookEl = bookRepository.findById(reservationDTO.getBook().getId()).orElseThrow(() -> new RuntimeException("Book not found"));

		if (!(bookEl.getCopies() > 0)) {
			throw new RuntimeException("Book is not available");
		}

		Reservation reservation = new Reservation();
		reservation.setUser(userEl);
		reservation.setBook(bookEl);
		reservation.setRentalAt(LocalDateTime.now());
		reservation.setRentalStatus(ReservationStatus.RENTED.getStatus());
		reservation.setRentalStatusChangedAt(LocalDateTime.now());

		// Update Book Availability
		int copies = bookEl.getCopies();
		bookEl.setCopies(copies - 1);

		this.bookRepository.save(bookEl);

		this.reservationRepository.save(reservation);
		
		return reservationDTO;
	}

	@Transactional
	public ReservationDTO updateReservationStatus(ReservationDTO reservationDTO) {

		Reservation reservationEl = reservationRepository.findByUserIdAndBookIdAndRentalStatus(reservationDTO.getUser().getId(),
				reservationDTO.getBook().getId(), ReservationStatus.RENTED.getStatus());

		reservationEl.setRentalStatus(ReservationStatus.RETURNED.getStatus());
		reservationEl.setRentalStatusChangedAt(LocalDateTime.now());

		// Update Book Availability
		Book bookEl = reservationEl.getBook();
		int copies = bookEl.getCopies();
		bookEl.setCopies(copies + 1);

		this.bookRepository.save(bookEl);

		this.reservationRepository.save(reservationEl);
		
		return reservationDTO;
	}
}