package com.example.agencia_viagens.service;

import java.util.List;

import com.example.agencia_viagens.entity.DestinationEntity;
import com.example.agencia_viagens.repository.DestinationRepository;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    private final DestinationRepository repository;

    public DestinationService(DestinationRepository repository) {
        this.repository = repository;
    }

    public List<DestinationEntity> getAllDestinations() {
        return repository.findAll();
    }

    public DestinationEntity getDestinationById(Long id){
        return repository.findById(id).orElse(null);
    }

    public DestinationEntity save(DestinationEntity destinationEntity) {
        return repository.save(destinationEntity);
    }

    public List<DestinationEntity> searchDestinations(String search) {
        return repository.findByNameContainingIgnoreCaseOrLocateContainingIgnoreCase(search, search);
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
            destinationEntity.setReviews(updatedDestinationEntity.getReviews());
        }

        return repository.save(destinationEntity);
    }

    public DestinationEntity addReview(Long id, Double rating) {
        DestinationEntity destinationEntity = getDestinationById(id);

        if (destinationEntity != null && rating != null) {
            destinationEntity.addReview(rating);
            return repository.save(destinationEntity);
        }

        return destinationEntity;
    }

    public boolean deleteDestination(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

}