package com.rating.ratingmicroservice.repository;

import com.rating.ratingmicroservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByTripId(int tripId);
    List<Rating> findByTouristId(int touristId);
}
