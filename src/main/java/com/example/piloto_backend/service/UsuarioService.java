package com.example.piloto_backend.service;

import com.example.piloto_backend.model.Usuario;
import com.example.piloto_backend.repository.UsuarioRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryIF usuarioRepositoryIF;

    public List<Usuario> read(){
        return this.usuarioRepositoryIF.findAll();
    }

    public Usuario register(Usuario user){
       return this.usuarioRepositoryIF.save(user);
    }

    public List<Usuario> login(String nome, String senha){
        return this.usuarioRepositoryIF.findByNomeAndSenha(nome, senha);
    }
}
