package com.example.agencia_viagens.service;

import java.util.List;

import com.example.agencia_viagens.dto.DestinationDTO;
import com.example.agencia_viagens.entity.DestinationEntity;
import com.example.agencia_viagens.repository.DestinationRepository;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {

    private final DestinationRepository repository;

    public DestinationService(DestinationRepository repository) {
        this.repository = repository;
    }

    public List<DestinationDTO> getAllDestinations() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public DestinationDTO getDestinationById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public DestinationDTO save(DestinationDTO destinationDTO) {
        DestinationEntity destinationEntity = toEntity(destinationDTO);
        return toDTO(repository.save(destinationEntity));
    }

    public List<DestinationDTO> searchDestinations(String search) {
        return repository.findByNameContainingIgnoreCaseOrLocateContainingIgnoreCase(search, search)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public DestinationDTO updateDestination(Long id, DestinationDTO updatedDestinationDTO) {
        DestinationEntity destinationEntity = repository.findById(id).orElse(null);

        if (destinationEntity == null) {
            return null;
        }

        if (updatedDestinationDTO.getName() != null) {
            destinationEntity.setName(updatedDestinationDTO.getName());
        }
        if (updatedDestinationDTO.getLocate() != null) {
            destinationEntity.setLocate(updatedDestinationDTO.getLocate());
        }
        if (updatedDestinationDTO.getDescription() != null) {
            destinationEntity.setDescription(updatedDestinationDTO.getDescription());
        }
        if (updatedDestinationDTO.getTravelPackets() != null) {
            destinationEntity.setTravelPackets(updatedDestinationDTO.getTravelPackets());
        }
        if (updatedDestinationDTO.getHotelAvailability() != null) {
            destinationEntity.setHotelAvailability(updatedDestinationDTO.getHotelAvailability());
        }
        if (updatedDestinationDTO.getTouristActivities() != null) {
            destinationEntity.setTouristActivities(updatedDestinationDTO.getTouristActivities());
        }
        if (updatedDestinationDTO.getReviews() != null) {
            destinationEntity.setReviews(updatedDestinationDTO.getReviews());
        }

        return toDTO(repository.save(destinationEntity));
    }

    public DestinationDTO addReview(Long id, Double rating) {
        DestinationEntity destinationEntity = repository.findById(id).orElse(null);

        if (destinationEntity != null && rating != null) {
            destinationEntity.addReview(rating);
            return toDTO(repository.save(destinationEntity));
        }

        return destinationEntity == null ? null : toDTO(destinationEntity);
    }

    public boolean deleteDestination(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    private DestinationEntity toEntity(DestinationDTO destinationDTO) {
        DestinationEntity destinationEntity = new DestinationEntity();
        destinationEntity.setName(destinationDTO.getName());
        destinationEntity.setLocate(destinationDTO.getLocate());
        destinationEntity.setTravelPackets(destinationDTO.getTravelPackets());
        destinationEntity.setHotelAvailability(destinationDTO.getHotelAvailability());
        destinationEntity.setDescription(destinationDTO.getDescription());
        destinationEntity.setTouristActivities(destinationDTO.getTouristActivities());
        destinationEntity.setReviews(destinationDTO.getReviews());
        return destinationEntity;
    }

    private DestinationDTO toDTO(DestinationEntity destinationEntity) {
        DestinationDTO destinationDTO = new DestinationDTO();
        destinationDTO.setId(destinationEntity.getId());
        destinationDTO.setName(destinationEntity.getName());
        destinationDTO.setLocate(destinationEntity.getLocate());
        destinationDTO.setTravelPackets(destinationEntity.getTravelPackets());
        destinationDTO.setHotelAvailability(destinationEntity.getHotelAvailability());
        destinationDTO.setDescription(destinationEntity.getDescription());
        destinationDTO.setTouristActivities(destinationEntity.getTouristActivities());
        destinationDTO.setReviews(destinationEntity.getReviews());
        destinationDTO.setAverage(destinationEntity.getAverage());
        return destinationDTO;
    }

}
