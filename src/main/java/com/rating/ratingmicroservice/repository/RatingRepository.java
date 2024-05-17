package com.rating.ratingmicroservice.repository;

import com.rating.ratingmicroservice.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
