package com.codelab.restOnlineLibrary.mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codelab.restOnlineLibrary.dto.book.BookDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Component
public class BookMapper {

	@Autowired
	private ReservationMapper reservationMapper;

	@Autowired
	private ReservationRepository reservationRepository;

	public BookDTO toDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setCategory(book.getCategory());
		bookDTO.setCopies(book.getCopies());
		bookDTO.setAvailable(book.isAvailable());
		bookDTO.setReservations(
				book.getReservations().stream().map(reservationMapper::ToDTO).collect(Collectors.toList()));
		return bookDTO;
	}

	public Book toEntity(BookDTO bookDTO) {

		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setTitle(bookDTO.getTitle());
		book.setCategory(bookDTO.getCategory());
		book.setCopies(bookDTO.getCopies());
		book.setAvailable(bookDTO.isAvailable());

		// To Reservation Entity
		List<Reservation> reservations = bookDTO.getReservations().stream().map(reservationDTO -> {

			Optional<Reservation> reservation = reservationRepository.findById(reservationDTO.getId());
			return reservation.orElseThrow(() -> new RuntimeException("Reservation not found"));

		}).collect(Collectors.toList());

		book.setReservations(reservations);

		return book;
	}
}