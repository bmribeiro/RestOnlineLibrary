package com.codelab.restOnlineLibrary.dto.views;

import java.time.LocalDateTime;

public class RentalDTO {

	private String rentalStatus;
	private LocalDateTime rentalAt;
	private LocalDateTime rentalStatusChangedAt;

	protected RentalDTO(Builder builder) {
		this.rentalStatus = builder.rentalStatus;
		this.rentalAt = builder.rentalAt;
		this.rentalStatusChangedAt = builder.rentalStatusChangedAt;
	}

	public String getRentalStatus() {
		return rentalStatus;
	}

	public LocalDateTime getRentalAt() {
		return rentalAt;
	}

	public LocalDateTime getRentalStatusChangedAt() {
		return rentalStatusChangedAt;
	}

	public static class Builder {
		private String rentalStatus;
		private LocalDateTime rentalAt;
		private LocalDateTime rentalStatusChangedAt;

		public Builder setRentalStatus(String rentalStatus) {
			this.rentalStatus = rentalStatus;
			return this;
		}

		public Builder setRentalAt(LocalDateTime rentalAt) {
			this.rentalAt = rentalAt;
			return this;
		}

		public Builder setRentalStatusChangedAt(LocalDateTime rentalStatusChangedAt) {
			this.rentalStatusChangedAt = rentalStatusChangedAt;
			return this;
		}

		public RentalDTO build() {
			return new RentalDTO(this);
		}
	}
}
