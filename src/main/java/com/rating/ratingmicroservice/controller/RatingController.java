package com.rating.ratingmicroservice.controller;

import com.rating.ratingmicroservice.entities.Rating;
import com.rating.ratingmicroservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RatingController {
    @Autowired
    private RatingService _ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating _rating){
        Rating createdRating = _ratingService.createRating(_rating);
        return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> ratings = _ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
    @PutMapping("/rating/{id}")
    public ResponseEntity<Void> updateRating(@PathVariable("id") int id, @RequestBody Rating _rating){
        _rating.setId(id);
        _ratingService.updateRating(_rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable("id") int id){
        _ratingService.deleteRating(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("id") int id){
        try {
            Rating rating = _ratingService.getRatingById(id);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
