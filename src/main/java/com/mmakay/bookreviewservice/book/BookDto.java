package com.mmakay.bookreviewservice.book;

import java.io.Serializable;

/**
 * DTO for {@link Book}
 */
public record BookDto(Integer id, String title, String author, String description, GenreDto genre) implements Serializable {
  }