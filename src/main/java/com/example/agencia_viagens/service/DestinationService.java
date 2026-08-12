package com.example.agencia_viagens.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.agencia_viagens.entity.Destination;

@Service
public class DestinationService {

    private ArrayList<Destination> destinos = new ArrayList<Destination>();

    public Destination save(Destination destino) {
        destinos.add(destino);
        return destino;
    }
}