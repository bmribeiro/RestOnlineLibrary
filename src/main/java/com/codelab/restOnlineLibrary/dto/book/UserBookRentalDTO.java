package com.codelab.restOnlineLibrary.dto.book;

import java.time.LocalDateTime;

/**
 * DTO (Data Transfer Object) that represents a book rented by the user. It can
 * be used to transfer data between application layers and also to represent
 * rental history based on the status of the book.
 * 
 * This DTO may include information for both currently rented books and books
 * that have been returned, depending on the status.
 */
public class UserBookRentalDTO {

	private Long id;
	private String title;
	private String category;
	private LocalDateTime reservedAt;

	/**
	 * Status of the book (e.g., "rented" or "returned"). This field determines
	 * whether the DTO represents a currently rented book or a book that has been
	 * returned, which can be used to track rental history.
	 */
	private String status;
	private LocalDateTime statusChangedAt;

	public UserBookRentalDTO() {
		super();
	}

	public UserBookRentalDTO(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
		this.reservedAt = builder.reservedAt;
		this.status = builder.status;
		this.statusChangedAt = builder.statusChangedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		return "UserBookRentalDTO [id=" + id + ", title=" + title + ", category=" + category + ", reservedAt="
				+ reservedAt + ", status=" + status + ", statusChangedAt=" + statusChangedAt + "]";
	}

	public static class Builder {

		private Long id;
		private String title;
		private String category;
		private LocalDateTime reservedAt;
		private String status;
		private LocalDateTime statusChangedAt;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setCategory(String category) {
			this.category = category;
			return this;
		}

		public Builder setReservedAt(LocalDateTime reservedAt) {
			this.reservedAt = reservedAt;
			return this;
		}

		public Builder setStatus(String status) {
			this.status = status;
			return this;
		}

		public Builder setStatusChangedAt(LocalDateTime statusChangedAt) {
			this.statusChangedAt = statusChangedAt;
			return this;
		}

		public UserBookRentalDTO build() {
			return new UserBookRentalDTO(this);
		}
	}

}
