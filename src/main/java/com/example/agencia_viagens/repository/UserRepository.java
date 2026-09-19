package com.example.agencia_viagens.repository;

import com.example.agencia_viagens.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
