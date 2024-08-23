package com.mmakay.bookreviewservice.review;

import com.mmakay.bookreviewservice.User;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserIdDto(@NotNull Integer id) implements Serializable {
}