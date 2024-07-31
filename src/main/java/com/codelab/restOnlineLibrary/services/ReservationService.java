package com.codelab.restOnlineLibrary.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.entities.Reservation;
import com.codelab.restOnlineLibrary.entities.UserApp;
import com.codelab.restOnlineLibrary.repositories.BookRepository;
import com.codelab.restOnlineLibrary.repositories.ReservationRepository;
import com.codelab.restOnlineLibrary.repositories.UserAppRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserAppRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Reservation createReservation(Long userId, Long bookId) {
    	
        UserApp user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        if (!(book.getCopies() > 0)) {
            throw new RuntimeException("Book is not available");
        }

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setBook(book);
        reservation.setReservedAt(LocalDateTime.now());
        reservation.setStatus("reserved");
        reservation.setStatusChangedAt(LocalDateTime.now());

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