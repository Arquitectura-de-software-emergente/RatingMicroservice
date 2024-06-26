package com.rating.ratingmicroservice.Infrastructure.persistence;

import com.rating.ratingmicroservice.domain.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByTripId(int tripId);
    List<Rating> findByTouristId(int touristId);
}
