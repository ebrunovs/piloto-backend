package com.example.piloto_backend.repository;

import com.example.piloto_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MaterialRepositoryIF extends JpaRepository<Material, Long> {
    // (privado = false)
    public List<Material> findByPrivadoFalse();

    // (privado = true)
    public List<Material> findByPrivadoTrue();

    //
    public List<Material> findByUserId(UUID userId);

}
