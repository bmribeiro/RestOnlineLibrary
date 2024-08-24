package com.codelab.restOnlineLibrary.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dataAnalysis.PopularBook;
import com.codelab.restOnlineLibrary.dto.views.book.BookViewDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserRentalDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.enums.ReservationStatus;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	public boolean deleteById(Long id) {

		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public List<UserRentalDTO> getUserBookRentals(Long userId) {

		// User reservations
		List<Reservation> reservations = reservationRepository.findByUserId(userId);

		// Books (ID) reserved by the user
		List<Long> bookIds = reservations.stream().map(reservation -> reservation.getBook().getId())
				.collect(Collectors.toList());

		// Books reserved by the user
		List<Book> books = bookRepository.findAllById(bookIds);

		return reservations.stream().map(reservation -> {

			// Find the book corresponding to the current reservation
			Book book = books.stream().filter(b -> b.getId().equals(reservation.getBook().getId())).findFirst()
					.orElseThrow(() -> new RuntimeException("Book not found"));

			// Build UserRentalDTO
			UserRentalDTO dto = (UserRentalDTO) new UserRentalDTO.Builder().setBookId(book.getId())
					.setTitle(book.getTitle()).setCategory(book.getCategory())
					.setRentalStatus(reservation.getRentalStatus()).setRentalAt(reservation.getRentalAt())
					.setRentalStatusChangedAt(reservation.getRentalStatusChangedAt()).build();

			return dto;

		}).collect(Collectors.toList());
	}

	public List<BookViewDTO> getAllBooksWithUserRentalStatus(Long userId) {

		// Retrieve all books
		List<Book> allBooks = bookRepository.findAll();

		// Retrieve active reservations for the user
		List<Reservation> rentals = reservationRepository.findByUserIdAndRentalStatus(userId,
				ReservationStatus.RENTED.getStatus());

		// Extract the IDs of books rented by the user
		List<Long> rentedBookIds = rentals.stream().map(rental -> rental.getBook().getId())
				.collect(Collectors.toList());

		return allBooks.stream().map(book -> {

			boolean rentedByUser = rentedBookIds.contains(book.getId());

			// BookViewDTO
			return new BookViewDTO.Builder().setId(book.getId()).setTitle(book.getTitle())
					.setCategory(book.getCategory()).setCopies(book.getCopies()).setAvailable(book.isAvailable())
					.setRentedByUser(rentedByUser).build();
		}).collect(Collectors.toList());
	}

	// Most popular book
	public PopularBook getMostPopularBook() {
		List<PopularBook> popularBooks = reservationRepository.findMostPopularBook();
		return popularBooks.isEmpty() ? null : popularBooks.get(0);
	}

	// Most popular book for each Category
	public List<PopularBook> getMostPopularBookByCategory() {

		List<PopularBook> listPopularBookByCategory = new ArrayList<>();

		// Distinct categories
		List<String> categories = reservationRepository.findDistinctCategories();

		// Iterate over each category and find the most popular book
		for (String category : categories) {
			List<PopularBook> popularBooks = reservationRepository.findMostPopularBookByCategory(category);

			// If list is not empty, add most popular book
			if (!popularBooks.isEmpty()) {
				listPopularBookByCategory.add(popularBooks.get(0));
			}
		}
		return listPopularBookByCategory;
	}

}