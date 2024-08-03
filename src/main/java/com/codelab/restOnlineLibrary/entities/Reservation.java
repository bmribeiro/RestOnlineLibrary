package com.codelab.restOnlineLibrary.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private AuthUser user;

	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

	@Column(name = "reserved_at", nullable = false)
	private LocalDateTime reservedAt;

	@Column(name = "status", length = 50, nullable = false)
	private String status;

	@Column(name = "status_changed_at", nullable = false)
	private LocalDateTime statusChangedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthUser getUser() {
		return user;
	}

	public void setUser(AuthUser user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDateTime getReservedAt() {
		return reservedAt;
	}

	public void setReservedAt(LocalDateTime reservedAt) {
		this.reservedAt = reservedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getStatusChangedAt() {
		return statusChangedAt;
	}

	public void setStatusChangedAt(LocalDateTime statusChangedAt) {
		this.statusChangedAt = statusChangedAt;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", user=" + user + ", book=" + book + ", reservedAt=" + reservedAt
				+ ", status=" + status + ", statusChangedAt=" + statusChangedAt + "]";
	}

}
