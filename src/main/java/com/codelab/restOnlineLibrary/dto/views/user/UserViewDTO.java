package com.codelab.restOnlineLibrary.dto.views.user;

import java.time.LocalDateTime;

public class UserViewDTO {

	private final Long id;
	private final String username;
	private final String email;
	private final String role;
	private final boolean userStatus;
	private final LocalDateTime createdAt;
	private final LocalDateTime userStatusChangedAt;

	private UserViewDTO(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.role = builder.role;
		this.userStatus = builder.userStatus;
		this.createdAt = builder.createdAt;
		this.userStatusChangedAt = builder.userStatusChangedAt;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUserStatusChangedAt() {
		return userStatusChangedAt;
	}

	// Builder
	public static class Builder {
		private Long id;
		private String username;
		private String email;
		private String role;
		private boolean userStatus;
		private LocalDateTime createdAt;
		private LocalDateTime userStatusChangedAt;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setRole(String role) {
			this.role = role;
			return this;
		}

		public Builder setUserStatus(boolean userStatus) {
			this.userStatus = userStatus;
			return this;
		}

		public Builder setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Builder setUserStatusChangedAt(LocalDateTime userStatusChangedAt) {
			this.userStatusChangedAt = userStatusChangedAt;
			return this;
		}

		public UserViewDTO build() {
			return new UserViewDTO(this);
		}
	}
}
