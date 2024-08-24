package com.codelab.restOnlineLibrary.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelab.restOnlineLibrary.constants.Constants;
import com.codelab.restOnlineLibrary.dataAnalysis.PopularBook;
import com.codelab.restOnlineLibrary.dto.views.book.BookViewDTO;
import com.codelab.restOnlineLibrary.dto.views.user.UserRentalDTO;
import com.codelab.restOnlineLibrary.entities.Book;
import com.codelab.restOnlineLibrary.services.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) throws IOException {

        Book savedBook = bookService.saveBook(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }
	

	@GetMapping("/books/user-status/{userId}")
	public ResponseEntity<List<BookViewDTO>> getAllBooksWithUserRentalStatus(@PathVariable Long userId) {
		List<BookViewDTO> books = bookService.getAllBooksWithUserRentalStatus(userId);
		return ResponseEntity.ok(books);
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteById(@PathVariable Long id) {

		if (bookService.deleteById(id)) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/books/rented")
	public ResponseEntity<List<UserRentalDTO>> getUserBookRentals(@RequestParam Long userId) {

		List<UserRentalDTO> rentals = bookService.getUserBookRentals(userId);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, Constants.APPLICATION_JSON);

		return new ResponseEntity<>(rentals, headers, HttpStatus.OK);
	}

	@GetMapping("/books/most-popular")
    public ResponseEntity<PopularBook> getMostPopularBook() {
		
        PopularBook mostPopularBook = bookService.getMostPopularBook();
        
        if (mostPopularBook != null) {
            return ResponseEntity.ok(mostPopularBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/most-popular-by-category")
    public ResponseEntity<List<PopularBook>> getMostPopularBookByCategory() {
    	
        List<PopularBook> mostPopularBooksByCategory = bookService.getMostPopularBookByCategory();
        
        if (mostPopularBooksByCategory != null && !mostPopularBooksByCategory.isEmpty()) {
            return ResponseEntity.ok(mostPopularBooksByCategory);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
	

}