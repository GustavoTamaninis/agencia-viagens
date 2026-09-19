package com.example.agencia_viagens.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DestinationDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String name;
    private String locate;
    private String travelPackets;
    private Boolean hotelAvailability;
    private String description;
    private String touristActivities;
    private List<Double> reviews;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double average;

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

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
}
