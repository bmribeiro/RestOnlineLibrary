package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.BookDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.mappers.BookMapper;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private BookMapper bookMapper;

	public List<BookDTO> findAll() {

		List<Book> books = bookRepository.findAll();
		return books.stream().map(bookMapper::toDTO).collect(Collectors.toList());
	}

	public Optional<BookDTO> findById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.map(bookMapper::toDTO);
	}

	public BookDTO save(BookDTO bookDTO) {
		Book book = bookMapper.toEntity(bookDTO);
		return bookMapper.toDTO(bookRepository.save(book));
	}

	public boolean deleteById(Long id) {

		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public List<BookDTO> reservationsByUser(Long userId) {
		List<Reservation> reservations = reservationRepository.findByUserId(userId);

		List<BookDTO> booksDTO = reservations.stream().map(reservation -> reservation.getBook()).distinct()
				.map(bookMapper::toDTO).collect(Collectors.toList());

		return booksDTO;
	}

}