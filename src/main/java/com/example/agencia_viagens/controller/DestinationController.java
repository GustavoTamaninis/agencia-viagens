package com.example.agencia_viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.agencia_viagens.entity.Destination;
import com.example.agencia_viagens.service.DestinationService;

import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination saved = destinationService.save(destination);
        return new ResponseEntity<Destination>(saved, HttpStatus.CREATED);
    }
}