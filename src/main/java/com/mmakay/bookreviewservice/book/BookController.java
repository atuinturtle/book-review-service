package com.mmakay.bookreviewservice.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;

	@GetMapping("/api/books")
	public List<BookDto> getBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/api/books/{id}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
		final var book = bookService.getBook(id);
		return ResponseEntity.ok(book);
	}

	@PostMapping("/api/books")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
		final var book = bookService.create(bookDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(book);
	}

	@PutMapping("/api/books/{id}")
	public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
		return ResponseEntity.ok(bookService.update(id, bookDto));
	}
}
