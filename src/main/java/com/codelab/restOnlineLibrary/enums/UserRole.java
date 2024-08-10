package com.codelab.restOnlineLibrary.enums;

public enum UserRole {
	ADMIN_ROLE("ADMIN"), USER_ROLE("USER");

	private final String role;

	UserRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public static UserRole fromString(String role) {
		for (UserRole r : UserRole.values()) {
			if (r.role.equalsIgnoreCase(role)) {
				return r;
			}
		}
		throw new IllegalArgumentException("Unknown role: " + role);
	}
}