package com.codelab.restOnlineLibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codelab.restOnlineLibrary.dataAnalysis.PopularBook;
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

	@Query("SELECT DISTINCT b.category FROM Book b")
	List<String> findDistinctCategories();

	@Query("SELECT b.category AS category, b.title AS title, COUNT(r.id) AS totalReservations " + "FROM Reservation r "
			+ "JOIN r.book b " + "GROUP BY b.title " + "ORDER BY COUNT(r.id) DESC")
	List<PopularBook> findMostPopularBook();

	@Query("SELECT b.category AS category, b.title AS title, COUNT(r.id) AS totalReservations " + "FROM Reservation r "
			+ "JOIN r.book b " + "WHERE b.category = :category " + "GROUP BY b.category, b.title "
			+ "ORDER BY totalReservations DESC")
	List<PopularBook> findMostPopularBookByCategory(String category);

}
