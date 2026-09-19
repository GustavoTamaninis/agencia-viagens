package com.example.agencia_viagens.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "destinations")
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String locate;
    private String travelPackets;
    private Boolean hotelAvailability; // Escolhemos usar um tipo de referência, pois o valor pode ser nulo.
    private String description;
    private String touristActivities;
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getTravelPackets() {
        return travelPackets;
    }

    public void setTravelPackets(String travelPackets) {
        this.travelPackets = travelPackets;
    }

    public Boolean getHotelAvailability() {
        return hotelAvailability;
    }

    public void setHotelAvailability(Boolean hotelAvailability) {
        this.hotelAvailability = hotelAvailability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTouristActivities() {
        return touristActivities;
    }

    public void setTouristActivities(String touristActivities) {
        this.touristActivities = touristActivities;
    }

    public List<Double> getReviews() {
        return reviewEntities.stream()
                .map(ReviewEntity::getRating)
                .map(value -> value == null ? null : value.doubleValue())
                .toList();
    }

    public void setReviews(List<Double> reviews) {
        reviewEntities.clear();
        if (reviews != null) {
            reviews.stream()
                    .map(rating -> {
                        ReviewEntity review = new ReviewEntity();
                        review.setRating(rating);
                        review.setDestination(this);
                        return review;
                    })
                    .forEach(reviewEntities::add);
        }
    }

    public void addReview(Double rating) {
        ReviewEntity review = new ReviewEntity();
        review.setRating(rating);
        review.setDestination(this);
        reviewEntities.add(review);
    }

    @JsonProperty("average")
    public Double getAverage() {
        List<Double> reviews = getReviews();
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        int count = 0;
        for (Double review : reviews) {
            if (review != null) {
                sum += review;
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        double average = sum / count;
        return Math.round(average * 100.0) / 100.0;
    }
}
