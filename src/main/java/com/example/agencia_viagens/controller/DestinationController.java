package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.entity.DestinationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.agencia_viagens.service.DestinationService;

import java.util.List;


@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<DestinationEntity>> getAllDestinations(){
        List<DestinationEntity> destinationEntities = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinationEntities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationEntity> getDestinationById(@PathVariable Long id){ // visualizar detalhes de um destino específico
        DestinationEntity destinationEntity = destinationService.getDestinationById(id);
        if(destinationEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinationEntity, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DestinationEntity>> searchDestinations(@RequestParam String search) {
        List<DestinationEntity> destinationEntities = destinationService.searchDestinations(search);

        return new ResponseEntity<>(destinationEntities, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DestinationEntity> createDestination(@RequestBody DestinationEntity destinationEntity) {
        DestinationEntity saved = destinationService.save(destinationEntity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationEntity> updateDestination(@PathVariable Long id, @RequestBody DestinationEntity destinationEntity) {
    DestinationEntity updated = destinationService.updateDestination(id, destinationEntity);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PutMapping("/{id}/reviews")
    public ResponseEntity<DestinationEntity> addReview(@PathVariable Long id, @RequestBody Double rating) {
        DestinationEntity updated = destinationService.addReview(id, rating);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        boolean deleted = destinationService.deleteDestination(id);

        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}