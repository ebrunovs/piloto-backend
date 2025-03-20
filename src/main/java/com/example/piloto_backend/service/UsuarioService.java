package com.example.piloto_backend.service;

import com.example.piloto_backend.model.Usuario;
import com.example.piloto_backend.repository.UsuarioRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryIF usuarioRepositoryIF;

    public List<Usuario> read() {
        return this.usuarioRepositoryIF.findAll();
    }

    public Usuario register(Usuario usuario) {
        return this.usuarioRepositoryIF.save(usuario);
    }

    public Optional<Usuario> login(String nome, String senha) {
        // Assumindo que você tem um método findByNomeAndSenha no repository
        // Se não tiver, você precisará implementá-lo
        // return this.usuarioRepositoryIF.findByNomeAndSenha(nome, senha);
        
       
        Optional<Usuario> usuario = this.usuarioRepositoryIF.findByNome(nome);
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario;
        }
        return Optional.empty();
    }
}