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
	private final BookMapper bookMapper;

	@GetMapping("/api/books")
	public List<BookDto> getBooks() {

		return bookService.getAll().stream()
				.map(bookMapper::toDto)
				.toList();
	}

	@GetMapping("/api/books/{id}")
	public ResponseEntity<BookDto> getBook(@PathVariable Long id) {

		final var book = bookService.getBook(id);

		return ResponseEntity.ok(bookMapper.toDto(book));
	}

	@PostMapping("/api/books")
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {

		final var book = bookMapper.toEntity(bookDto);
		final var savedBook = bookService.save(book);
		final var outDto = bookMapper.toDto(savedBook);

		return ResponseEntity.status(HttpStatus.CREATED).body(outDto);
	}

	@PutMapping("/api/books/{id}")
	public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {

		final var updated = bookService.update(id, bookDto);
		final var outDto = bookMapper.toDto(updated);

		return ResponseEntity.ok(outDto);
	}
}
