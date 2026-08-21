package com.example.agencia_viagens.entity;

import java.util.List;

public class Destination {
    private Long id;
    private String name;
    private String locate;
    private String travelPackets;
    private Boolean hotelAvailability; // Escolhemos usar um tipo de referência, pois o valor pode ser nulo.
    private String description;
    private String touristActivities;
    private List<String> reviews; // Usamos uma Lista, porque Arrays no Java não são dinâmicos.

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

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }
}
