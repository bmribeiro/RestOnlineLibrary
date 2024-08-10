package com.codelab.restOnlineLibrary.dto.views.user;

import com.codelab.restOnlineLibrary.dto.views.RentalDTO;

public class UserRentalDTO extends RentalDTO {

	private Long bookId;
	private String title;
	private String category;

	private UserRentalDTO(Builder builder) {
		super(builder);
		this.bookId = builder.bookId;
		this.title = builder.title;
		this.category = builder.category;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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

	public static class Builder extends RentalDTO.Builder {
		private Long bookId;
		private String title;
		private String category;

		public Builder setBookId(Long bookId) {
			this.bookId = bookId;
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

		@Override
		public UserRentalDTO build() {
			return new UserRentalDTO(this);
		}
	}
}