package com.codelab.restOnlineLibrary.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.codelab.restOnlineLibrary.dto.ReservationDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;
import com.codelab.restOnlineLibrary.repositories.BookRepository;

@Component
public class ReservationMapper {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthUserRepository authUserRepository;

	public ReservationDTO ToDTO(Reservation reservation) {
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setId(reservation.getId());
		reservationDTO.setBookId(reservation.getBook().getId());
		reservationDTO.setUserId(reservation.getUser().getId());
		reservationDTO.setReservedAt(reservation.getReservedAt());
		reservationDTO.setStatus(reservation.getStatus());
		reservationDTO.setStatusChangedAt(reservation.getStatusChangedAt());
		return reservationDTO;
	}

	public Reservation toEntity(ReservationDTO reservationDTO) {

		Book book = bookRepository.findById(reservationDTO.getBookId())
				.orElseThrow(() -> new RuntimeException("Book not found"));

		AuthUser user = authUserRepository.findById(reservationDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		// Reservation Entity
		Reservation reservation = new Reservation();
		reservation.setId(reservationDTO.getId());
		reservation.setBook(book);
		reservation.setUser(user);
		reservation.setReservedAt(reservationDTO.getReservedAt());
		reservation.setStatus(reservationDTO.getStatus());
		reservation.setStatusChangedAt(reservationDTO.getStatusChangedAt());

		return reservation;
	}

}
