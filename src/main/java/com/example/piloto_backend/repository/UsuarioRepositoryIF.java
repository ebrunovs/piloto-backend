package com.example.piloto_backend.repository;

import com.example.piloto_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepositoryIF extends JpaRepository<Usuario, UUID> {
    List<Usuario> findByNomeAndSenha(String nome, String senha);
}
