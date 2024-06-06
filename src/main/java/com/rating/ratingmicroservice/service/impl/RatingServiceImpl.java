package com.rating.ratingmicroservice.service.impl;

import com.rating.ratingmicroservice.client.TripClient;
import com.rating.ratingmicroservice.dto.TripDto;
import com.rating.ratingmicroservice.entities.Rating;
import com.rating.ratingmicroservice.http.RatingResponse;
import com.rating.ratingmicroservice.repository.RatingRepository;
import com.rating.ratingmicroservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository _ratingRepository;

    @Autowired
    private TripClient tripClient;

    @Override
    public Rating createRating(Rating _rating) {
        return _ratingRepository.save(_rating);
    }

    @Override
    public List<RatingResponse> getAllRatings() {
        List<Rating> ratings = (List<Rating>) _ratingRepository.findAll();
        List<RatingResponse> responses = new ArrayList<>();
        for (Rating rating : ratings) {
            TripDto trip = tripClient.getTripById(rating.getTripId());
            RatingResponse response = RatingResponse.builder()
                    .id(rating.getId())
                    .tripId(rating.getTripId())
                    .touristId(rating.getTouristId())
                    .score(rating.getScore())
                    .creationDate(rating.getCreationDate())
                    .trip(trip)  // Incluir el objeto TripDto en la respuesta
                    .build();
            responses.add(response);
        }
        return responses;
    }

    @Override
    public void updateRating(Rating _rating) {
        _ratingRepository.save(_rating);
    }

    @Override
    public void deleteRating(int _id) {
        _ratingRepository.deleteById(_id);
    }

    @Override
    public List<Rating> getRatingsByTripId(int tripId) {
        return _ratingRepository.findByTripId(tripId);
    }

    @Override
    public List<RatingResponse> getRatingsByTripIdWithTrip(int tripId) {
        List<Rating> ratings = _ratingRepository.findByTripId(tripId);
        List<RatingResponse> responses = new ArrayList<>();
        for (Rating rating : ratings) {
            TripDto trip = tripClient.getTripById(rating.getTripId());
            RatingResponse response = RatingResponse.builder()
                    .id(rating.getId())
                    .tripId(rating.getTripId())
                    .touristId(rating.getTouristId())
                    .score(rating.getScore())
                    .creationDate(rating.getCreationDate())
                    .trip(trip)  // Incluir el objeto TripDto en la respuesta
                    .build();
            responses.add(response);
        }
        return responses;
    }

    @Override
    public RatingResponse getRatingById(int _id) {
        Rating rating = _ratingRepository.findById(_id).orElseThrow(() -> new RuntimeException("Rating not found"));
        TripDto trip = tripClient.getTripById(rating.getTripId());
        return RatingResponse.builder()
                .id(rating.getId())
                .tripId(rating.getTripId())
                .touristId(rating.getTouristId())
                .score(rating.getScore())
                .creationDate(rating.getCreationDate())
                .trip(trip)  // Incluir el objeto TripDto en la respuesta
                .build();
    }
}
