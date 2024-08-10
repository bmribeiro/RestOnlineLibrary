package com.codelab.restOnlineLibrary.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "auth_user")
public class AuthUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false)
	@Size(max = 100)
	private String username;

	@Column(nullable = false)
	@Size(max = 100)
	private String email;

	@Column(nullable = false)
	@Size(max = 100)
	private String password;

	@Column(nullable = false)
	private String role;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "user_status", nullable = false)
	private boolean userStatus;

	@Column(name = "user_status_changed_at", nullable = false)
	private LocalDateTime userStatusChangedAt;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Reservation> reservations;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public LocalDateTime getUserStatusChangedAt() {
		return userStatusChangedAt;
	}

	public void setUserStatusChangedAt(LocalDateTime userStatusChangedAt) {
		this.userStatusChangedAt = userStatusChangedAt;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "AuthUser [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + role + ", createdAt=" + createdAt + ", userStatus=" + userStatus
				+ ", userStatusChangedAt=" + userStatusChangedAt + ", reservations=" + reservations + "]";
	}

}