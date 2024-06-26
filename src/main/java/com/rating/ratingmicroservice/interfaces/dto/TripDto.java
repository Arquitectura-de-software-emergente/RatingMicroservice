package com.rating.ratingmicroservice.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private int id;
    private int agencyId;
    private String title;
    private String description;
    private int duration;
    private String difficulty;
}
