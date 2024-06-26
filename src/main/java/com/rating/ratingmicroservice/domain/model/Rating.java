package com.rating.ratingmicroservice.domain.model;

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
    private int id;
    @Column(name = "score", nullable = false)
    private int score;
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    @Column(name = "tourist_id", nullable = false)
    private int touristId;


    @Column(name = "trip_id", nullable = false)
    private int tripId;
}
