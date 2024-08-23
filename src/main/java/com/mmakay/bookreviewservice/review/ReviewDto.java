package com.mmakay.bookreviewservice.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link Review}
 */
public record ReviewDto(@NotNull(message = "Id must be not null")
                        Integer id,
                        @NotNull
                        UserIdDto user,
                        @NotNull
                        BookIdDto book,
                        @NotNull(message = "Rating must be not null")
                        @Min(value = 1, message = "Rating must be bigger than 0")
                        @Max(value = 5, message = "Rating must be lower than 6")
                        Integer rating,
                        String reviewText) implements Serializable {
}