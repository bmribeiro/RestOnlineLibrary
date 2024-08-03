package com.codelab.restOnlineLibrary.dto;

public record LoginDTO(String email, char[] password) {

	public String email() {
		return email;
	}

	public char[] getPassword() {
		return password;
	}

}