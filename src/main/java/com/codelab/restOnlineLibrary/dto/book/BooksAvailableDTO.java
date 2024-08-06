package com.codelab.restOnlineLibrary.dto.book;

/**
 * DTO (Data Transfer Object) representing books available for rent. This DTO
 * includes information about each book's availability and whether the currently
 * logged-in user has rented the book or not.
 */
public class BooksAvailableDTO {

	private Long id;
	private String title;
	private String category;
	private int copies;
	private boolean available;
	private boolean userHasRented;

	public BooksAvailableDTO() {
	}

	private BooksAvailableDTO(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
		this.copies = builder.copies;
		this.available = builder.available;
		this.userHasRented = builder.userHasRented;
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

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isUserHasRented() {
		return userHasRented;
	}

	public void setUserHasRented(boolean userHasRented) {
		this.userHasRented = userHasRented;
	}

	@Override
	public String toString() {
		return "BooksAvailableDTO [id=" + id + ", title=" + title + ", category=" + category + ", copies=" + copies
				+ ", available=" + available + ", userHasRented=" + userHasRented + "]";
	}

	public static class Builder {
		private Long id;
		private String title;
		private String category;
		private int copies;
		private boolean available;
		private boolean userHasRented;

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

		public Builder setUserHasRented(boolean userHasRented) {
			this.userHasRented = userHasRented;
			return this;
		}

		public BooksAvailableDTO build() {
			return new BooksAvailableDTO(this);
		}
	}
}
