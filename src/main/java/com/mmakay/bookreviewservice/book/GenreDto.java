package com.mmakay.bookreviewservice.book;

import java.io.Serializable;

/**
 * DTO for {@link Genre}
 */
public record GenreDto(Integer id, String name) implements Serializable {
}