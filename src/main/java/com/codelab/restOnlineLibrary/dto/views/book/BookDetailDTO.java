package com.codelab.restOnlineLibrary.dto.views.book;

import java.util.List;

public class BookDetailDTO {

	BookViewDTO booksView;

	List<RentalUsersDTO> rentalUsers;

	public BookViewDTO getBooksView() {
		return booksView;
	}

	public void setBooksView(BookViewDTO booksView) {
		this.booksView = booksView;
	}

	public List<RentalUsersDTO> getRentalUsers() {
		return rentalUsers;
	}

	public void setRentalUsers(List<RentalUsersDTO> rentalUsers) {
		this.rentalUsers = rentalUsers;
	}

}
