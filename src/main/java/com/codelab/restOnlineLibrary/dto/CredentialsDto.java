package com.codelab.restOnlineLibrary.dto;

public record CredentialsDto(String login, char[] password) {

	public String getLogin() {
		return login;
	}

	public char[] getPassword() {
		return password;
	}

}