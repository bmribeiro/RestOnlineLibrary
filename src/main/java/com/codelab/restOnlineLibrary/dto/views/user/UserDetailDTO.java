package com.codelab.restOnlineLibrary.dto.views.user;

import java.util.List;

public class UserDetailDTO {

	UserViewDTO userView;

	List<RentalBooksDTO> rentalBooks;

	public UserViewDTO getUserView() {
		return userView;
	}

	public void setUserView(UserViewDTO userView) {
		this.userView = userView;
	}

	public List<RentalBooksDTO> getRentalBooks() {
		return rentalBooks;
	}

	public void setRentalBooks(List<RentalBooksDTO> rentalBooks) {
		this.rentalBooks = rentalBooks;
	}

}
