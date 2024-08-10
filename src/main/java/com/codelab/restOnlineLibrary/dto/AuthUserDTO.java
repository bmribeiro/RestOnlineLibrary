package com.codelab.restOnlineLibrary.dto;

public class AuthUserDTO {

	private Long id;
	private String username;
	private String token;
	private String role;

	public AuthUserDTO() {
	}

	private AuthUserDTO(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.token = builder.token;
		this.role = builder.role;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// Builder
	public static class Builder {
		private Long id;
		private String username;
		private String token;
		private String role;

		public Builder() {
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setToken(String token) {
			this.token = token;
			return this;
		}

		public Builder setRole(String role) {
			this.role = role;
			return this;
		}

		public AuthUserDTO build() {
			return new AuthUserDTO(this);
		}
	}

}
