package com.codelab.restOnlineLibrary.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.repositories.AuthUserRepository;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AuthUserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Reservation createReservation(Reservation reservation) {
    	
    	AuthUser userEl = userRepository.findById(reservation.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        Book bookEl = bookRepository.findById(reservation.getUser().getId()).orElseThrow(() -> new RuntimeException("Book not found"));

        if (!(bookEl.getCopies() > 0)) {
            throw new RuntimeException("Book is not available");
        }

        reservation.setReservedAt(LocalDateTime.now());
        reservation.setStatus("reserved");
        reservation.setStatusChangedAt(LocalDateTime.now());
        
        // Update Book Availability
        int copies = bookEl.getCopies();
        bookEl.setCopies(copies - 1);
        
        this.bookRepository.save(bookEl);

        return reservationRepository.save(reservation);
    }

	public Reservation updateReservationStatus(Long reservationId, String newStatus) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setStatus(newStatus);
        reservation.setStatusChangedAt(LocalDateTime.now());

        return reservationRepository.save(reservation);
    }
}