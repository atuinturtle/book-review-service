package com.mmakay.bookreviewservice.review;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {
	Review toEntity(ReviewDto reviewDto);

	ReviewDto toDto(Review review);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Review partialUpdate(ReviewDto reviewDto, @MappingTarget Review review);
}