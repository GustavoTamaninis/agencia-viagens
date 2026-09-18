package com.example.agencia_viagens.repository;

import com.example.agencia_viagens.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {
    List<DestinationEntity> findByNameContainingIgnoreCaseOrLocateContainingIgnoreCase(
            String name,
            String locate
    );
}
