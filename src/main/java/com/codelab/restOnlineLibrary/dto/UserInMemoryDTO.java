package com.codelab.restOnlineLibrary.dto;

import java.time.LocalDateTime;

public class UserInMemoryDTO {

	private Long id;
	private String username;
	private String email;
	private String profile;
	private LocalDateTime created;
	private boolean active;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "UserAppDTO [id=" + id + ", username=" + username + ", email=" + email + ", profile=" + profile
				+ ", created=" + created + ", active=" + active + "]";
	}

}