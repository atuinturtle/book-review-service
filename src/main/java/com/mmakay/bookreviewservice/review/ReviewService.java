package com.mmakay.bookreviewservice.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;
	private final ReviewMapper reviewMapper;

	public List<ReviewDto> getAllReviews() {
		return reviewRepository.findAll().stream()
				.map(reviewMapper::toDto)
				.toList();
	}

	public List<ReviewDto> getReviewsByBookId(final Long bookId) {
		return reviewRepository.findByBook_Id(bookId.intValue())
				.map(reviewMapper::toDto)
				.toList();
	}

	public ReviewDto getReviewsById(final Long id) {
		return reviewRepository.findById(id.intValue())
				.map(reviewMapper::toDto)
				.orElseThrow(() -> new NoSuchElementException("Review not found"));
	}

	public ReviewDto create(final ReviewDto reviewDto) {
		return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(reviewDto)));
	}

	public Double getAverageRating(final Long bookId) {
		return reviewRepository.findByBook_Id(bookId.intValue())
				.mapToInt(Review::getRating)
				.average()
				.orElseThrow(() -> new NoSuchElementException("Review not found"));
	}
}
