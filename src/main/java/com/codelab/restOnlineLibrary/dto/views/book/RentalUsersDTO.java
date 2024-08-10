package com.codelab.restOnlineLibrary.dto.views.book;

import com.codelab.restOnlineLibrary.dto.views.RentalDTO;

public class RentalUsersDTO extends RentalDTO {

	private Long id;
	private String username;

	private RentalUsersDTO(Builder builder) {
		super(builder);
		this.id = builder.id;
		this.username = builder.username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static class Builder extends RentalDTO.Builder {
		private Long id;
		private String username;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		@Override
		public RentalUsersDTO build() {
			return new RentalUsersDTO(this);
		}
	}
}