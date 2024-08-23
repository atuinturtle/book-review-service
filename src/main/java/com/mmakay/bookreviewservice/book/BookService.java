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

	List<Book> getAll() {
		return bookRepository.findAll();
	}

	public Book getBook(final Long id) {
		return bookRepository.findById(id.intValue())
				.orElseThrow(() -> new NoSuchElementException("Book not found with id: %d".formatted(id)));
	}

	Book save(final Book book) {
		return bookRepository.save(book);
	}

	public Book update(final Long id, final BookDto bookDto) {
		final var book = getBook(id);

		final var updatedBook = bookMapper.partialUpdate(bookDto, book);

		return save(updatedBook);

	}
}
