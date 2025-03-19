package com.example.piloto_backend.repository;

import com.example.piloto_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MaterialRepositoryIF extends JpaRepository<Material, Long> {
    // 1️⃣ Buscar materiais públicos (privado = false)
    public List<Material> findByPrivadoFalse();

    // 2️⃣ Buscar materiais privados (privado = true)
    public List<Material> findByPrivadoTrue();

    // 3️⃣ Buscar materiais pelo usuário
    public List<Material> findByUserId(UUID userId);

}
