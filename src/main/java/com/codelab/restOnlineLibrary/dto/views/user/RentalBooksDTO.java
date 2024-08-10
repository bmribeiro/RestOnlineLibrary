package com.codelab.restOnlineLibrary.dto.views.user;

import com.codelab.restOnlineLibrary.dto.views.RentalDTO;

public class RentalBooksDTO extends RentalDTO {

	private int id;
	private String title;
	private String category;

	private RentalBooksDTO(Builder builder) {
		super(builder);
		this.id = builder.id;
		this.title = builder.title;
		this.category = builder.category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public static class Builder extends RentalDTO.Builder {
		private int id;
		private String title;
		private String category;

		public Builder setId(int id) {
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

		public RentalBooksDTO build() {
			return new RentalBooksDTO(this);
		}
	}

}
