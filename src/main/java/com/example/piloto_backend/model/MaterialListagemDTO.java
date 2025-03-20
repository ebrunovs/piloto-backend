package com.example.piloto_backend.model;

import java.util.UUID;

public record MaterialListagemDTO(Long id, String titulo, String disciplina, String assunto, String data_da_postagem, String link, String privado, UUID userId) {

    public MaterialListagemDTO(Material material) {
        this(material.getId(), material.getTitulo(), material.getDisciplina(), material.getAssunto(), material.getData_da_postagem(), material.getLink(), material.getPrivado(), material.getUserId());
    }

}