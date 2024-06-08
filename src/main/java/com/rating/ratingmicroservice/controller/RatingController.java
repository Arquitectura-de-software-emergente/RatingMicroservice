package com.rating.ratingmicroservice.controller;

import com.rating.ratingmicroservice.entities.Rating;
import com.rating.ratingmicroservice.http.RatingResponse;
import com.rating.ratingmicroservice.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RatingController {
    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    private RatingService _ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating _rating) {
        Rating createdRating = _ratingService.createRating(_rating);
        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<RatingResponse>> getAllRating() {
        List<RatingResponse> ratings = _ratingService.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PutMapping("/rating/{id}")
    public ResponseEntity<Void> updateRating(@PathVariable("id") int id, @RequestBody Rating _rating) {
        _rating.setId(id);
        _ratingService.updateRating(_rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable("id") int id) {
        _ratingService.deleteRating(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<RatingResponse> getRatingById(@PathVariable("id") int id) {
        try {
            RatingResponse rating = _ratingService.getRatingById(id);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ratings/by-trip/{tripId}")
    public ResponseEntity<List<?>> getRatingsByTripId(
            @PathVariable("tripId") int tripId,
            @RequestParam(name = "includeTrips", required = false, defaultValue = "false") boolean includeTrips) {
        logger.info("Received request to get ratings by tripId: {}, includeTrips: {}", tripId, includeTrips);

        if (includeTrips) {
            List<RatingResponse> ratingWithTrips = _ratingService.getRatingsByTripIdWithTrip(tripId);
            logger.info("Retrieved ratings with trip details for tripId: {}", tripId);
            return new ResponseEntity<>(ratingWithTrips, HttpStatus.OK);
        } else {
            List<Rating> ratings = _ratingService.getRatingsByTripId(tripId);
            logger.info("Retrieved ratings for tripId: {}", tripId);
            return new ResponseEntity<>(ratings, HttpStatus.OK);
        }
    }
    @GetMapping("/ratings/by-tourist/{touristId}")
    public ResponseEntity<List<?>> getRatingsByTouristId(@PathVariable("touristId") int touristId) {
        List<Rating> ratings = _ratingService.getRatingsByTouristId(touristId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
