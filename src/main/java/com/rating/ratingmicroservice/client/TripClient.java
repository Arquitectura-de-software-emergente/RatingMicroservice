package com.rating.ratingmicroservice.client;

import com.rating.ratingmicroservice.dto.TripDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TripClient {
    private final WebClient webClient;
    private final ConcurrentHashMap<Integer, TripDto> cache = new ConcurrentHashMap<>();

    @Autowired
    public TripClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/v1").build();
    }

    public List<TripDto> getAllTrips() {
        try {
            return webClient.get()
                    .uri("/trip")
                    .retrieve()
                    .bodyToFlux(TripDto.class)
                    .collectList()
                    .block();
        } catch (WebClientResponseException e) {
            // Manejo de error
            return null;
        } catch (Exception e) {
            // Manejo de error
            return null;
        }
    }

    public TripDto getTripById(int tripId) {
        if (cache.containsKey(tripId)) {
            return cache.get(tripId);
        }
        try {
            TripDto trip = webClient.get()
                    .uri("/trip/{id}", tripId)
                    .retrieve()
                    .bodyToMono(TripDto.class)
                    .block();
            cache.put(tripId, trip);
            return trip;
        } catch (WebClientResponseException e) {
            // Manejo de error
            return null;
        } catch (Exception e) {
            // Manejo de error
            return null;
        }
    }
}
