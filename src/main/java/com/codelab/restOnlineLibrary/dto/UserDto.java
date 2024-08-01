package com.codelab.restOnlineLibrary.dto;

public class UserDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String login;
	private String token;

	private UserDto(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.login = builder.login;
		this.token = builder.token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public UserDto(Long id, String firstName, String lastName, String login, String token) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.token = token;
	}



	public static class Builder {
		private Long id;
		private String firstName;
		private String lastName;
		private String login;
		private String token;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setLogin(String login) {
			this.login = login;
			return this;
		}

		public Builder setToken(String token) {
			this.token = token;
			return this;
		}

		public UserDto build() {
			return new UserDto(this);
		}
	}

}
