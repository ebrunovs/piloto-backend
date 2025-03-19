package com.example.piloto_backend.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID userId;
    private String titulo;
    private String disciplina;
    private String assunto;
    private String data_da_postagem;
    private String link;
    private String privado;
    private Boolean isOwner;

    public Material(){}

    public Material(String titulo, String disciplina, String assunto, String data_da_postagem, String link, String privado){
        this.titulo = titulo;
        this.disciplina = disciplina;
        this.assunto = assunto;
        this.data_da_postagem = data_da_postagem;
        this.link = link;
        this.privado = privado;
    }

    public Long getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getData_da_postagem() {
        return data_da_postagem;
    }

    public void setData_da_postagem(String data_da_postagem) {
        this.data_da_postagem = data_da_postagem;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrivado() {
        return privado;
    }

    public void setPrivado(String privado) {
        this.privado = privado;
    }

    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }
}
