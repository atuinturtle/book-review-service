package com.mmakay.bookreviewservice.review;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.mmakay.bookreviewservice.book.Book}
 */
public record BookIdDto(@NotNull Integer id) implements Serializable {
}