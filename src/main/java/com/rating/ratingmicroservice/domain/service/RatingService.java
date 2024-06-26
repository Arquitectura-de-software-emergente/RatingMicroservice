package com.rating.ratingmicroservice.domain.service;

import com.rating.ratingmicroservice.domain.model.Rating;
import com.rating.ratingmicroservice.interfaces.dto.RatingResponse;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating _rating);
    List<RatingResponse> getAllRatings();
    void updateRating(Rating _rating);

    List<Rating> getRatingsByTripId(int tripId);
    List<Rating> getRatingsByTouristId(int touristId);
    List<RatingResponse> getRatingsByTripIdWithTrip(int tripId);

    void deleteRating(int _id);
    RatingResponse getRatingById(int _id);
}
