package com.codelab.restOnlineLibrary.dto.book;

import java.time.LocalDateTime;

public class BookRentalDTO {

	private Long id;
	private String title;
	private String category;
	private LocalDateTime reservedAt;
	private String status;
	private LocalDateTime statusChangedAt;

	public BookRentalDTO() {
		super();
	}

	public BookRentalDTO(Builder builder) {
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
		return "BookRentalDTO [id=" + id + ", title=" + title + ", category=" + category + ", reservedAt=" + reservedAt
				+ ", status=" + status + ", statusChangedAt=" + statusChangedAt + "]";
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

		public BookRentalDTO build() {
			return new BookRentalDTO(this);
		}
	}
	
}
