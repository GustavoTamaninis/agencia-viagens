package com.example.agencia_viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.agencia_viagens.entity.Destination;
import com.example.agencia_viagens.service.DestinationService;

import java.util.List;


@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<Destination>> getAllDestinations(){
        List<Destination> destinations = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Long id){ // visualizar detalhes de um destino específico
        Destination destination = destinationService.getDestinationById(id);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Destination>> searchDestinations(@RequestParam String search) {
        List<Destination> destinations = destinationService.getAllDestinations()
                .stream()
                .filter(destination ->
                        destination.getName().toLowerCase().contains(search.toLowerCase()) ||
                        destination.getLocate().toLowerCase().contains(search.toLowerCase()))
                .toList();

        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination saved = destinationService.save(destination);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable Long id, @RequestBody Destination destination) {
    Destination updated = destinationService.updateDestination(id, destination);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PutMapping("/{id}/reviews")
    public ResponseEntity<Destination> addReview(@PathVariable Long id, @RequestBody Double rating) {
        Destination updated = destinationService.addReview(id, rating);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}