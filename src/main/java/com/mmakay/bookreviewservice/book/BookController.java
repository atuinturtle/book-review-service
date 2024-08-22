package com.mmakay.bookreviewservice.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;

	@GetMapping("/api/books")
	public List<BookDto> getBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("api/books/{id}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.getBook(id));
	}
}
