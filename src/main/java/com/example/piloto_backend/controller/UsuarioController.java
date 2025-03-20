package com.example.piloto_backend.controller;

import com.example.piloto_backend.model.Usuario;
import com.example.piloto_backend.model.UsuarioLoginDTO;
import com.example.piloto_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> read() {
        try {
            List<Usuario> usuarios = this.usuarioService.read();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar usuários: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Usuario user) {
        try {
            Usuario novoUsuario = this.usuarioService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erro nos dados fornecidos: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao registrar usuário: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        try {
            Optional<Usuario> usuario = this.usuarioService.login(usuarioLoginDTO.nome(), usuarioLoginDTO.senha());
            
            if (usuario.isPresent()) {
                return ResponseEntity.ok(usuario.get());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Dados de login inválidos: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao processar login: " + e.getMessage());
        }
    }
}