package com.example.piloto_backend.controller;

import com.example.piloto_backend.model.Material;
import com.example.piloto_backend.model.MaterialListagemDTO;
import com.example.piloto_backend.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materiais")
@CrossOrigin(origins = "*") // Adicionado para consistência com UsuarioController
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<?> readMateriais() {
        try {
            List<MaterialListagemDTO> materiais = this.materialService.readMateriais();
            return ResponseEntity.ok(materiais);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar materiais: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createMaterial(@RequestBody Material material) {
        try {
            Material novoMaterial = this.materialService.createMaterial(material);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoMaterial);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Dados do material inválidos: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao criar material: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable("id") Long id) {
        try {
            this.materialService.deleteMaterial(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Material não encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao excluir material: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Material material) {
        try {
            Material materialAtualizado = this.materialService.updateMaterial(material);
            return ResponseEntity.ok(materialAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Dados do material inválidos: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Material não encontrado: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao atualizar material: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPorId(@PathVariable Long id) {
        try {
            Material material = this.materialService.getById(id);
            if (material != null) {
                return ResponseEntity.ok(material);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Material com ID " + id + " não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar material: " + e.getMessage());
        }
    }

    @GetMapping("/public")
    public ResponseEntity<?> getPublicMaterials() {
        try {
            List<Material> materiaisPublicos = materialService.getMaterialsByPublic();
            return ResponseEntity.ok(materiaisPublicos);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar materiais públicos: " + e.getMessage());
        }
    }

    @GetMapping("/private")
    public ResponseEntity<?> getPrivateMaterials() {
        try {
            List<Material> materiaisPrivados = materialService.getMaterialsByPrivate();
            return ResponseEntity.ok(materiaisPrivados);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar materiais privados: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getMaterialsByUser(@PathVariable UUID userId) {
        try {
            List<Material> materiaisDoUsuario = materialService.getMaterialsByUser(userId);
            return ResponseEntity.ok(materiaisDoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("ID de usuário inválido: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Erro ao buscar materiais do usuário: " + e.getMessage());
        }
    }
}