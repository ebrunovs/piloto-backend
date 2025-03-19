package com.example.piloto_backend.repository;

import com.example.piloto_backend.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepositoryIF extends JpaRepository<Material, Long> {
}
