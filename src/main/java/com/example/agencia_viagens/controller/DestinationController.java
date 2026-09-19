package com.example.agencia_viagens.controller;

import com.example.agencia_viagens.dto.DestinationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.agencia_viagens.service.DestinationService;

import java.util.List;


@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public ResponseEntity<List<DestinationDTO>> getAllDestinations() {
        return new ResponseEntity<>(destinationService.getAllDestinations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDTO> getDestinationById(@PathVariable Long id) {
        DestinationDTO destinationDTO = destinationService.getDestinationById(id);
        if (destinationDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinationDTO, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DestinationDTO>> searchDestinations(@RequestParam String search) {
        return new ResponseEntity<>(destinationService.searchDestinations(search), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DestinationDTO> createDestination(@RequestBody DestinationDTO destinationDTO) {
        DestinationDTO saved = destinationService.save(destinationDTO);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationDTO> updateDestination(
            @PathVariable Long id,
            @RequestBody DestinationDTO destinationDTO) {
        DestinationDTO updated = destinationService.updateDestination(id, destinationDTO);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PutMapping("/{id}/reviews")
    public ResponseEntity<DestinationDTO> addReview(@PathVariable Long id, @RequestBody Double rating) {
        DestinationDTO updated = destinationService.addReview(id, rating);
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