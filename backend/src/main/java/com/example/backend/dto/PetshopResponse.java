package com.example.backend.dto;

public class PetshopResponse {
    public String nome;
    public double preco;

    public PetshopResponse(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
