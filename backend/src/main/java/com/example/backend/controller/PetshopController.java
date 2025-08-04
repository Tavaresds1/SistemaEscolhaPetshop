package com.example.backend.controller;


import com.example.backend.dto.PetshopRequest;
import com.example.backend.dto.PetshopResponse;
import com.example.backend.model.Petshop;
import com.example.backend.service.PetshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/petshop")
@CrossOrigin(origins = "*")
public class PetshopController {

    @Autowired
    private PetshopService service;

    @PostMapping
    // A anotação @Valid agora vai funcionar corretamente com o GlobalExceptionHandler.
    public PetshopResponse buscarMelhorPetshop(@Valid @RequestBody PetshopRequest request) {
        Petshop melhor = service.encontrarMelhorPetshop(request.getData(), request.getQtdPequenos(), request.getQtdGrandes());
        double preco = service.calcularPreco(melhor, request.getData(), request.getQtdPequenos(), request.getQtdGrandes());
        return new PetshopResponse(melhor.getNome(), preco);
    }
}
