package com.example.agencia_viagens.service;

import com.example.agencia_viagens.dto.UserDTO;
import com.example.agencia_viagens.entity.UserEntity;
import com.example.agencia_viagens.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(this::toDTO);
    }

    public UserDTO save(UserDTO userDTO) {
        UserEntity user = toEntity(userDTO);
        UserEntity savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    public UserDTO update(Long id, UserDTO userDetails) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o ID: " + id));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        // Atualiza a senha apenas se ela foi enviada na requisição
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(userDetails.getPassword());
        }

        UserEntity updatedUser = userRepository.save(user);
        return toDTO(updatedUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // Métodos auxiliares de mapeamento (Entity <-> DTO)
    private UserDTO toDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        // A senha não vai para o DTO de resposta por causa do WRITE_ONLY, mas podemos setar se necessário
        return dto;
    }

    private UserEntity toEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}