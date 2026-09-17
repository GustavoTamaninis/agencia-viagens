package com.example.agencia_viagens.service;

import java.util.ArrayList;
import java.util.List;

import com.example.agencia_viagens.entity.DestinationEntity;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    private final ArrayList<DestinationEntity> destinationEntities = new ArrayList<>();

    public Long nextId = 1L;

    public List<DestinationEntity> getAllDestinations(){
        return this.destinationEntities;
    }

    public DestinationEntity getDestinationById(Long id){
        // Garante que d.getId() não é null antes de chamar o .equals()
        return destinationEntities.stream()
                .filter(d -> d.getId() != null && d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public DestinationEntity save(DestinationEntity destinationEntity) {
        if(destinationEntity.getId() == null){
            destinationEntity.setId(nextId++);
        }
        destinationEntities.add(destinationEntity);
        return destinationEntity;
    }

    public DestinationEntity updateDestination(Long id, DestinationEntity updatedDestinationEntity) {
        DestinationEntity destinationEntity = getDestinationById(id);

        if (destinationEntity == null) {
            return null;
        }

        // Atualização de dados básicos
        if (updatedDestinationEntity.getName() != null) {
            destinationEntity.setName(updatedDestinationEntity.getName());
        }
        if (updatedDestinationEntity.getLocate() != null) {
            destinationEntity.setLocate(updatedDestinationEntity.getLocate());
        }
        if (updatedDestinationEntity.getDescription() != null) {
            destinationEntity.setDescription(updatedDestinationEntity.getDescription());
        }

        // Atualização dos demais campos da entidade
        if (updatedDestinationEntity.getTravelPackets() != null) {
            destinationEntity.setTravelPackets(updatedDestinationEntity.getTravelPackets());
        }
        if (updatedDestinationEntity.getHotelAvailability() != null) {
            destinationEntity.setHotelAvailability(updatedDestinationEntity.getHotelAvailability());
        }
        if (updatedDestinationEntity.getTouristActivities() != null) {
            destinationEntity.setTouristActivities(updatedDestinationEntity.getTouristActivities());
        }

        // Atualização da lista de avaliações
        if (updatedDestinationEntity.getReviews() != null) {
            destinationEntity.setReviews(new ArrayList<>(updatedDestinationEntity.getReviews()));
        }

        return destinationEntity;
    }

    public DestinationEntity addReview(Long id, Double rating) {
        DestinationEntity destinationEntity = getDestinationById(id);

        if (destinationEntity != null && rating != null) {
            if (destinationEntity.getReviews() == null) {
                destinationEntity.setReviews(new ArrayList<>());
            }

            destinationEntity.getReviews().add(rating);
        }

        return destinationEntity;
    }

    public boolean deleteDestination(Long id) {
        return destinationEntities.removeIf(destinationEntity -> destinationEntity.getId() != null && destinationEntity.getId().equals(id));
    }

}