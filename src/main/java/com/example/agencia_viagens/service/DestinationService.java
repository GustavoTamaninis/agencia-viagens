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

    public Destination updateDestination(Long id, Destination destinationDetails) {
        // 1. Busca o destino na lista
        Destination destination = getDestinationById(id);

        // 2. Garante que só altera se o objeto realmente for encontrado
        if (destination != null) {
            destination.setName(destinationDetails.getName());
            destination.setLocate(destinationDetails.getLocate());
            destination.setDescription(destinationDetails.getDescription());
        }

        // 3. Retorna o objeto atualizado (ou null se não encontrou)
        return destination;
    }

    public Destination addReview(Long id, String rating) {
        Destination destination = getDestinationById(id);

        if (destination != null && rating != null) {
            if (destination.getReviews() == null) {
                destination.setReviews(new ArrayList<>());
            }

            String cleanRating = rating.replace("\"", "").trim();
            destination.getReviews().add(cleanRating);
        }

        return destination;
    }

}