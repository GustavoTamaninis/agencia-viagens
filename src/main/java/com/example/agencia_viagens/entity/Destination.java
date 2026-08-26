package com.example.agencia_viagens.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@SuppressWarnings("unused")
public class Destination {
    private Long id;
    private String name;
    private String locate;
    private String travelPackets;
    private Boolean hotelAvailability; // Escolhemos usar um tipo de referência, pois o valor pode ser nulo.
    private String description;
    private String touristActivities;
    private List<Double> reviews; // Usamos uma Lista, porque Arrays no Java não são dinâmicos.

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
        return reviews;
    }

    public void setReviews(List<Double> reviews) {
        this.reviews = reviews;
    }

    @JsonProperty("average")
    public Double getAverage() {
        if (this.reviews == null || this.reviews.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        int count = 0;
        for (Double review : this.reviews) {
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
