package com.codelab.restOnlineLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByUserId(Long userId);
	
	List<Reservation> findByUserIdAndStatus(Long userId, String status);
	
	Reservation findByUserIdAndBookIdAndStatus(Long userId, Long bookId, String status);
	
	
}
