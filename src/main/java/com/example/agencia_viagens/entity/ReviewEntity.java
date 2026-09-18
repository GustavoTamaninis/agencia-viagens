package com.example.agencia_viagens.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "destination_review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private DestinationEntity destination;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal rating;

    public Long getId() {
        return id;
    }

    public DestinationEntity getDestination() {
        return destination;
    }

    public void setDestination(DestinationEntity destination) {
        this.destination = destination;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating == null ? null : BigDecimal.valueOf(rating);
    }
}
