package com.example.agencia_viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agencia_viagens.entity.Destination;
import com.example.agencia_viagens.service.DestinationService;

@RestController
@RequestMapping("/api/destinos")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping
    public ResponseEntity<Destination> cadastrar(@RequestBody Destination destino) {
        Destination salvo = destinationService.save(destino);
        return new ResponseEntity<Destination>(salvo, HttpStatus.CREATED);
    }
}