package com.codelab.restOnlineLibrary.dto;

import java.time.LocalDateTime;

public class ReservationDTO {

	private Long bookId;
	private Long userId;
	private Long id;
	private LocalDateTime reservedAt;
	private String status;
	private LocalDateTime statusChangedAt;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
