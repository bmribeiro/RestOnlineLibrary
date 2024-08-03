package com.codelab.restOnlineLibrary.dto;

import java.util.List;

public class BookDTO {

	private Long id;
	private String title;
	private String category;
	private int copies;
	private boolean available;
	private List<ReservationDTO> reservations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public List<ReservationDTO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", category=" + category + ", copies=" + copies
				+ ", available=" + available + "]";
	}
}