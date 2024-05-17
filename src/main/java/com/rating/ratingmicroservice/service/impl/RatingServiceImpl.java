package com.rating.ratingmicroservice.service.impl;

import com.rating.ratingmicroservice.entities.Rating;
import com.rating.ratingmicroservice.repository.RatingRepository;
import com.rating.ratingmicroservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository _ratingRepository;
    @Override
    public Rating createRating(Rating _rating) {
        return _ratingRepository.save(_rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return (List<Rating>) _ratingRepository.findAll();
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
    public Rating getRatingById(int _id) {
        if(_ratingRepository.findById(_id).isPresent()){
            return _ratingRepository.findById(_id).get();
        }else{
            throw new RuntimeException("Rating not found");
        }
    }
}
