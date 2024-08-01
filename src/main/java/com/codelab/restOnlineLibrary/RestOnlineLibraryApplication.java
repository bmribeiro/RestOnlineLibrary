package com.codelab.restOnlineLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.codelab.restOnlineLibrary.*")
public class RestOnlineLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestOnlineLibraryApplication.class, args);
	}

}
