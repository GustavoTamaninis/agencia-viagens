package com.example.agencia_viagens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agencia_viagens.entity.Destination;

@Service
public class DestinationService {

    private final ArrayList<Destination> destinations = new ArrayList<>();

    public List<Destination> getAllDestinations(){
        return this.destinations;
    }

    public Destination getDestinationById(Long id){
        // Garante que d.getId() não é null antes de chamar o .equals()
        return destinations.stream()
                .filter(d -> d.getId() != null && d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Destination save(Destination destination) {
        destinations.add(destination);
        return destination;
    }

    public Destination updateDestination(Long id, Destination updatedDestination) {
        Destination destination = getDestinationById(id);

        if (destination == null) {
            return null;
        }

        // Atualização de dados básicos
        if (updatedDestination.getName() != null) {
            destination.setName(updatedDestination.getName());
        }
        if (updatedDestination.getLocate() != null) {
            destination.setLocate(updatedDestination.getLocate());
        }
        if (updatedDestination.getDescription() != null) {
            destination.setDescription(updatedDestination.getDescription());
        }

        // Atualização dos demais campos da entidade
        if (updatedDestination.getTravelPackets() != null) {
            destination.setTravelPackets(updatedDestination.getTravelPackets());
        }
        if (updatedDestination.getHotelAvailability() != null) {
            destination.setHotelAvailability(updatedDestination.getHotelAvailability());
        }
        if (updatedDestination.getTouristActivities() != null) {
            destination.setTouristActivities(updatedDestination.getTouristActivities());
        }

        // Atualização da lista de avaliações
        if (updatedDestination.getReviews() != null) {
            destination.setReviews(new ArrayList<>(updatedDestination.getReviews()));
        }

        return destination;
    }

    public Destination addReview(Long id, Double rating) {
        Destination destination = getDestinationById(id);

        if (destination != null && rating != null) {
            if (destination.getReviews() == null) {
                destination.setReviews(new ArrayList<>());
            }

            destination.getReviews().add(rating);
        }

        return destination;
    }

}