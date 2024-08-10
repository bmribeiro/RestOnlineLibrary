package com.codelab.restOnlineLibrary.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.dto.views.book.BookDetailDTO;
import com.codelab.restOnlineLibrary.dto.views.book.BookViewDTO;
import com.codelab.restOnlineLibrary.dto.views.book.RentalUsersDTO;
import com.codelab.restOnlineLibrary.dto.views.user.RentalBooksDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserDetailDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserViewDTO;
import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.mappers.AuthUserMapper;
import com.codelab.restOnlineLibrary.repositories.AuthRepository;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Service
public class AdminService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthRepository authRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private AuthUserMapper authUserMapper;
	
	public List<UserViewDTO> findAll() {

		List<AuthUser> authUsers = authRepository.findAll();
		return authUsers.stream().map(authUserMapper::toDTO).collect(Collectors.toList());
	}


	public BookDetailDTO getBookDetailById(Long bookId) {

		// Fetch the book by its ID
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

		// Fetch reservations associated with the book
		List<Reservation> reservations = reservationRepository.findByBook(book);

		// Convert the list of reservations to a list of RentalUsersDTO
		List<RentalUsersDTO> userBookRentals = reservations.stream().map(this::reservationToRentalDTO)
				.collect(Collectors.toList());

		// Create and complete the BookDetailDTO
		BookDetailDTO bookDetail = new BookDetailDTO();
		
		// Build the BookViewDTO with book details
		BookViewDTO bookView = new BookViewDTO.Builder()
				.setId(book.getId())
				.setTitle(book.getTitle())
				.setCategory(book.getCategory())
				.setCopies(book.getCopies())
				.setAvailable(book.isAvailable())
				.build();
		
		bookDetail.setBooksView(bookView);
		bookDetail.setRentalUsers(userBookRentals);

		return bookDetail;
	}

	// Method to convert a Reservation to RentalUsersDTO
	private RentalUsersDTO reservationToRentalDTO(Reservation reservation) {
	    return (RentalUsersDTO) new RentalUsersDTO.Builder()
	        .setId(reservation.getUser().getId()) 
	        .setUsername(reservation.getUser().getUsername())
	        .setRentalStatus(reservation.getRentalStatus())
	        .setRentalAt(reservation.getRentalAt())
	        .setRentalStatusChangedAt(reservation.getRentalStatusChangedAt())
	        .build();
	}

	public UserDetailDTO getUserDetailById(Long userId) {
		
		// Fetch the user by ID
		AuthUser user = authRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		// Fetch reservations associated with the user
		List<Reservation> reservations = reservationRepository.findByUser(user);

		// Convert the list of reservations to a list of RentalBooksDTO
		List<RentalBooksDTO> userBookRentalDTOs = reservations.stream().map(this::reservationToRentalBooksDTO)
				.collect(Collectors.toList());
		
		UserDetailDTO userDetails = new UserDetailDTO();

		// Build the UserViewDTO with user details
		UserViewDTO userView = new UserViewDTO.Builder()
				.setUsername(user.getUsername())
				.setEmail(user.getEmail())
				.setRole(user.getRole())
				.setUserStatus(user.isUserStatus())
				.setCreatedAt(user.getCreatedAt())
				.setUserStatusChangedAt(user.getUserStatusChangedAt())
				.build();
		
		userDetails.setUserView(userView);
		userDetails.setRentalBooks(userBookRentalDTOs);

		return userDetails;
	}
	
	// Method to convert a Reservation to RentalBooksDTO
	private RentalBooksDTO reservationToRentalBooksDTO(Reservation reservation) {
	    return (RentalBooksDTO) new RentalBooksDTO.Builder()
	        .setId(reservation.getBook().getId().intValue())
	        .setTitle(reservation.getBook().getTitle())
	        .setCategory(reservation.getBook().getCategory())
	        .setRentalStatus(reservation.getRentalStatus()) 
	        .setRentalAt(reservation.getRentalAt())
	        .setRentalStatusChangedAt(reservation.getRentalStatusChangedAt())
	        .build();
	}
}
