package com.codelab.restOnlineLibrary.dto.views.book;

public class BookViewDTO {

	private Long id;
	private String title;
	private String category;
	private int copies;
	private boolean available;
	private boolean rentedByUser;

	// Detail
	private String bookDescription;
	private String url;

	private BookViewDTO(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
		this.copies = builder.copies;
		this.available = builder.available;
		this.rentedByUser = builder.rentedByUser;
		this.bookDescription = builder.bookDescription;
		this.url = builder.url;
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

	public String getBookDescription() {
		return bookDescription;
	}

	public String getUrl() {
		return url;
	}

	// Builder
	public static class Builder {
		private Long id;
		private String title;
		private String category;
		private int copies;
		private boolean available;
		private boolean rentedByUser;

		// Detail
		private String bookDescription;
		private String url;

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

		public Builder setBookDescription(String bookDescription) {
			this.bookDescription = bookDescription;
			return this;
		}

		public Builder setUrl(String url) {
			this.url = url;
			return this;
		}

		public BookViewDTO build() {
			return new BookViewDTO(this);
		}
	}
}
