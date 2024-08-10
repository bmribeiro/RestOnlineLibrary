package com.codelab.restOnlineLibrary.dto.views.book;

public class BookViewDTO {

	private Long id;
	private String title;
	private String category;
	private int copies;
	private boolean available;
	private boolean rentedByUser;

	private BookViewDTO(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
		this.copies = builder.copies;
		this.available = builder.available;
		this.rentedByUser = builder.rentedByUser;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public int getCopies() {
		return copies;
	}

	public boolean isAvailable() {
		return available;
	}

	public boolean isRentedByUser() {
		return rentedByUser;
	}

	// Builder
	public static class Builder {
		private Long id;
		private String title;
		private String category;
		private int copies;
		private boolean available;
		private boolean rentedByUser;

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

		public Builder setCopies(int copies) {
			this.copies = copies;
			return this;
		}

		public Builder setAvailable(boolean available) {
			this.available = available;
			return this;
		}

		public Builder setRentedByUser(boolean rentedByUser) {
			this.rentedByUser = rentedByUser;
			return this;
		}

		public BookViewDTO build() {
			return new BookViewDTO(this);
		}
	}
}
