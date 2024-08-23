package com.mmakay.bookreviewservice.book;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Book}
 */
public record BookDto(@NotNull
                      Integer id,
                      @NotNull
                      String title,
                      @NotNull
                      String author,
                      @NotNull
                      String description,
                      @NotNull
                      GenreDto genre) implements Serializable {
  }