package com.mmakay.bookreviewservice.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public Stream<Review> getReviewsByBookId(final Long bookId) {
		return reviewRepository.findByBook_Id(bookId.intValue());
	}

	public Review getReviewsById(final Long id) {
		return reviewRepository.findById(id.intValue())
				.orElseThrow(() -> new NoSuchElementException("Review not found"));
	}

	public Review save(final Review entity) {
		return reviewRepository.save(entity);
	}

	public Double getAverageRating(final Long bookId) {
		return getReviewsByBookId(bookId)
				.mapToInt(Review::getRating)
				.average()
				.orElseThrow(() -> new NoSuchElementException("No review found"));
	}
}
