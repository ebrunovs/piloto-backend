package com.example.piloto_backend.controller;

import com.example.piloto_backend.model.Usuario;
import com.example.piloto_backend.model.UsuarioLoginDTO;
import com.example.piloto_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> read(){
        return this.usuarioService.read();
    }

    @PostMapping
    public Usuario register(@RequestBody Usuario user){
        return this.usuarioService.register(user);
    }

    @PostMapping("/login")
    public List<Usuario> login(@RequestBody UsuarioLoginDTO usuarioLoginDTO){
        return this.usuarioService.login(usuarioLoginDTO.nome(), usuarioLoginDTO.senha());
    }
}
