package com.example.piloto_backend.service;

import com.example.piloto_backend.repository.MaterialRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepositoryIF materialRepositoryIF;
}
