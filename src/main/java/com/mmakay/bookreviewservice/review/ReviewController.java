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

	@GetMapping("/api/reviews/")
	public List<ReviewDto> getReviews() {
		return reviewService.getAllReviews();
	}

	@Transactional
	@GetMapping("/api/reviews/book/{bookId}")
	public List<ReviewDto> getReviewsByBookId(@PathVariable("bookId") Long bookId) {
		return reviewService.getReviewsByBookId(bookId);
	}

	@GetMapping("/api/reviews/{id}")
	public ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(reviewService.getReviewsById(id));
	}

	@PostMapping("/api/review/")
	public ResponseEntity<ReviewDto> createReview(@Valid @RequestBody ReviewDto reviewDto) {
		return ResponseEntity.ok(reviewService.create(reviewDto));
	}

	@Transactional
	@GetMapping("/api/reviews/book/{bookId}/average-rating")
	public ResponseEntity<Double> getAverageRating(@PathVariable("bookId") Long bookId) {
		return ResponseEntity.ok(reviewService.getAverageRating(bookId));
	}
}
