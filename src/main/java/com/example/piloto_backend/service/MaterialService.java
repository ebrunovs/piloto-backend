package com.example.piloto_backend.service;

import com.example.piloto_backend.model.Material;
import com.example.piloto_backend.model.MaterialListagemDTO;
import com.example.piloto_backend.repository.MaterialRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepositoryIF materialRepositoryIF;

    public List<MaterialListagemDTO> readMateriais() {
        return this.materialRepositoryIF.findAll().stream().map(MaterialListagemDTO::new).toList();
    }

    public Material createMaterial(Material material){
        return this.materialRepositoryIF.save(material);
    }

    public Material updateMaterial(Material material){
        return this.materialRepositoryIF.save(material);
    }

    public void deleteMaterial(Long id){
        this.materialRepositoryIF.deleteById(id);
    }

    public Material getById(Long id){
        return this.materialRepositoryIF.findById(id).orElse(null);
    }

    public List<Material> getMaterialsByPublic() {
        return this.materialRepositoryIF.findByPrivadoFalse();
    }

    public List<Material> getMaterialsByPrivate() {
        return this.materialRepositoryIF.findByPrivadoTrue();
    }

    public List<Material> getMaterialsByUser(UUID userId) {
        return this.materialRepositoryIF.findByUserId(userId);
    }
}
