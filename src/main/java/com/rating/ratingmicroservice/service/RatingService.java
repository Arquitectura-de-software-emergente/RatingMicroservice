package com.rating.ratingmicroservice.service;

import com.rating.ratingmicroservice.entities.Rating;

import java.util.List;

public interface RatingService {
    public abstract Rating createRating(Rating _rating);
    public abstract List<Rating> getAllRating();
    public abstract void updateRating(Rating _rating);
    public abstract void deleteRating(int _id);
    public abstract Rating getRatingById(int _id);
}
