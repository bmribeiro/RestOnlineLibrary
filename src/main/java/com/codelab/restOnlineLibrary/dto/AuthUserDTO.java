package com.codelab.restOnlineLibrary.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AuthUserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String token;
	private String profile;
	private LocalDateTime created;
	private boolean active;
	private List<ReservationDTO> reservations;

	public AuthUserDTO() {
	}

	private AuthUserDTO(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.token = builder.token;
		this.profile = builder.profile;
		this.created = builder.created;
		this.active = builder.active;
		this.reservations = builder.reservations;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public List<ReservationDTO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "AuthUserDTO{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", email='" + email + '\'' + ", token='" + token + '\'' + ", profile='" + profile + '\''
				+ ", created=" + created + ", active=" + active + ", reservations=" + reservations + '}';
	}

	public static class Builder {
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String token;
		private String profile;
		private LocalDateTime created;
		private boolean active;
		private List<ReservationDTO> reservations;

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

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setToken(String token) {
			this.token = token;
			return this;
		}

		public Builder setProfile(String profile) {
			this.profile = profile;
			return this;
		}

		public Builder setCreated(LocalDateTime created) {
			this.created = created;
			return this;
		}

		public Builder setActive(boolean active) {
			this.active = active;
			return this;
		}

		public Builder setReservations(List<ReservationDTO> reservations) {
			this.reservations = reservations;
			return this;
		}

		public AuthUserDTO build() {
			return new AuthUserDTO(this);
		}
	}
}
