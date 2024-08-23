package com.mmakay.bookreviewservice.review;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;
	private final ReviewMapper reviewMapper;

	@GetMapping("/api/reviews")
	public List<ReviewDto> getReviews() {
		return reviewService.getAllReviews().stream()
				.map(reviewMapper::toDto)
				.toList();
	}

	@Transactional
	@GetMapping("/api/reviews/book/{bookId}")
	public List<ReviewDto> getReviewsByBookId(@PathVariable("bookId") Long bookId) {
		return reviewService.getReviewsByBookId(bookId)
				.map(reviewMapper::toDto)
				.toList();
	}

	@GetMapping("/api/reviews/{id}")
	public ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") Long id) {
		final var reviews = reviewService.getReviewsById(id);
		final var outDto = reviewMapper.toDto(reviews);

		return ResponseEntity.ok(outDto);
	}

	@PostMapping("/api/review/")
	public ResponseEntity<ReviewDto> createReview(@Valid @RequestBody ReviewDto inDto) {
		final var review = reviewMapper.toEntity(inDto);
		final var savedreview = reviewService.save(review);
		final var outDto = reviewMapper.toDto(savedreview);

		return ResponseEntity.ok(outDto);
	}

	@Transactional
	@GetMapping("/api/reviews/book/{bookId}/average-rating")
	public ResponseEntity<Double> getAverageRating(@PathVariable("bookId") Long bookId) {
		final var averageRating = reviewService.getAverageRating(bookId);

		return ResponseEntity.ok(averageRating);
	}
}
