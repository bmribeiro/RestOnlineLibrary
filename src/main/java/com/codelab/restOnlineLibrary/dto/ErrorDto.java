package com.codelab.restOnlineLibrary.dto;

public record ErrorDto(String message) {

	public String getMessage() {
		return message;
	}

}
