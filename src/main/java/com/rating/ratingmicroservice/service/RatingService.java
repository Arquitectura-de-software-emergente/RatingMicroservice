package com.rating.ratingmicroservice.service;

import com.rating.ratingmicroservice.entities.Rating;
import com.rating.ratingmicroservice.http.RatingResponse;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating _rating);
    List<RatingResponse> getAllRatings();
    void updateRating(Rating _rating);

    List<Rating> getRatingsByTripId(int tripId);
    List<RatingResponse> getRatingsByTripIdWithTrip(int tripId);

    void deleteRating(int _id);
    RatingResponse getRatingById(int _id);
}
