package com.codelab.restOnlineLibrary.dto;

import com.codelab.restOnlineLibrary.entities.AuthUser;
import com.codelab.restOnlineLibrary.entities.Book;

public class ReservationDTO {

	private Long id;
	private AuthUser user;
	private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthUser getUser() {
		return user;
	}

	public void setUser(AuthUser user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", user=" + user + ", book=" + book + "]";
	}

}
