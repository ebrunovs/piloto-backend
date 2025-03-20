package com.example.piloto_backend.controller;

import com.example.piloto_backend.model.Material;
import com.example.piloto_backend.model.MaterialListagemDTO;
import com.example.piloto_backend.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public List<MaterialListagemDTO> readMateriais(){
        return this.materialService.readMateriais();
    }

    @PostMapping
    public Material createMaterial(@RequestBody Material material){
        return this.materialService.createMaterial(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterial(@PathVariable("id") Long id){
        this.materialService.deleteMaterial(id);
    }

    @PutMapping("/{id}")
    public Material atualizar(@RequestBody Material material) {
        return this.materialService.updateMaterial(material);
    }

    @GetMapping("/{id}")
    public Material getPorId(@PathVariable Long id) {
        return this.materialService.getById(id);
    }

    @GetMapping("/public")
    public List<Material> getPublicMaterials() {
        return materialService.getMaterialsByPublic();
    }

    @GetMapping("/private")
    public List<Material> getPrivateMaterials() {
        return materialService.getMaterialsByPrivate();
    }

    @GetMapping("/user/{userId}")
    public List<Material> getMaterialsByUser(@PathVariable UUID userId) {
        return materialService.getMaterialsByUser(userId);
    }
}
