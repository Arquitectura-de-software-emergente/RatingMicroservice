package com.rating.ratingmicroservice.interfaces.dto;

import com.rating.ratingmicroservice.interfaces.dto.TripDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingResponse {
    private int id;
    private int tripId;
    private int touristId;
    private Date creationDate;
    private int score;

    private TripDto trip;  // Incluir el objeto TripDto
}
