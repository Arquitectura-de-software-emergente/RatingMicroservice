package com.rating.ratingmicroservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "score",nullable = false)
    private int Score;
    @Column(name = "creation_date",nullable = false)
    private Date CreationDate;
    @Column(name = "tourist_id",nullable = false)
    private int TouristId;
    @Column(name = "trip_id",nullable = false)
    private int TripId;

}
