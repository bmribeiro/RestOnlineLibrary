package com.codelab.restOnlineLibrary.enums;

public enum ReservationStatus {
	RENTED("rented"), RETURNED("returned");

	private final String status;

	ReservationStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public static ReservationStatus fromString(String status) {
		for (ReservationStatus s : ReservationStatus.values()) {
			if (s.status.equalsIgnoreCase(status)) {
				return s;
			}
		}
		throw new IllegalArgumentException("Unknown status: " + status);
	}
}