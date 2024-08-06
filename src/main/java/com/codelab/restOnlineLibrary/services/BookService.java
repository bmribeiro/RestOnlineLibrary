package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codelab.restOnlineLibrary.dto.book.BookDTO;
import com.codelab.restOnlineLibrary.dto.book.BooksAvailableDTO;
import com.codelab.restOnlineLibrary.dto.book.UserBookRentalDTO;
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

	public List<UserBookRentalDTO> getUserBookRentals(Long userId) {

		// User reservations
		List<Reservation> reservations = reservationRepository.findByUserId(userId);

		// Id of books reserved by the user
		List<Long> bookIds = reservations.stream().map(reservation -> reservation.getBook().getId())
				.collect(Collectors.toList());

		// Books reserved by the user
		List<Book> books = bookRepository.findAllById(bookIds);

		return reservations.stream()

				// transforms each element of the stream
				.map(reservation -> {

					// used to find the book corresponding to the current reservation
					Book book = books.stream()

							// book associated with the current reservation
							.filter(b -> b.getId().equals(reservation.getBook().getId())).findFirst()
							.orElseThrow(() -> new RuntimeException("Book not found"));

					// Build UserBookRentalDTO
					UserBookRentalDTO dto = new UserBookRentalDTO.Builder().setId(book.getId())
							.setTitle(book.getTitle()).setCategory(book.getCategory())
							.setReservedAt(reservation.getReservedAt()).setStatus(reservation.getStatus())
							.setStatusChangedAt(reservation.getStatusChangedAt()).build();

					return dto;

				}).collect(Collectors.toList());
	}

	public List<BooksAvailableDTO> getAllBooksWithUserRentalStatus(Long userId) {

		// Books available
		List<Book> allBooks = bookRepository.findAll();

		// Ative reservations for the session user
		List<Reservation> rentals = reservationRepository.findByUserIdAndStatus(userId, "rented");

		// IDs of books the user has rented
		List<Long> rentedBookIds = rentals.stream().map(rental -> rental.getBook().getId())
				.collect(Collectors.toList());

		return allBooks.stream().map(book -> {

			// Build BooksAvailableDTO
			return new BooksAvailableDTO.Builder().setId(book.getId()).setTitle(book.getTitle())
					.setCategory(book.getCategory()).setCopies(book.getCopies()).setAvailable(book.isAvailable())
					.setUserHasRented(rentedBookIds.contains(book.getId())).build();

		}).collect(Collectors.toList());

	}

}