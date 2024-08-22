package com.mmakay.bookreviewservice.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream()
				.map(bookMapper::toDto)
				.toList();
	}

	public BookDto getBook(final Long id) {
		return bookRepository.findById(id.intValue())
				.map(bookMapper::toDto)
				.orElseThrow(() -> new NoSuchElementException("Book not found with id: %d".formatted(id)));
	}
}
