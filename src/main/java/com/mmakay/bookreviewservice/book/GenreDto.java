package com.mmakay.bookreviewservice.book;

import java.io.Serializable;

/**
 * DTO for {@link com.mmakay.bookreviewservice.Genre}
 */
public record GenreDto(Integer id, String name) implements Serializable {
}