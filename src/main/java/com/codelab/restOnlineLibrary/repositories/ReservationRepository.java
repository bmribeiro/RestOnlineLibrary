package com.codelab.restOnlineLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findByBook(Book book);
	
	List<Reservation> findByUser(AuthUser user);

	List<Reservation> findByUserId(Long userId);
	
	List<Reservation> findByUserIdAndRentalStatus(Long userId, String status);
	
	Reservation findByUserIdAndBookIdAndRentalStatus(Long userId, Long bookId, String status);
	
	
}
