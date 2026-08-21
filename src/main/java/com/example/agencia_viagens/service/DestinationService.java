package com.example.agencia_viagens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.agencia_viagens.entity.Destination;

@Service
public class DestinationService {

    private ArrayList<Destination> destinations = new ArrayList<Destination>();

    public List<Destination> getAllDestinations(){
        return this.destinations;
    }

    public Destination getDestinationById(Long id){
        Destination destination = destinations.stream().filter(d -> d.getId() == id).findFirst().get();
        return destination;
    }

    public Destination save(Destination destination) {
        destinations.add(destination);
        return destination;
    }
}