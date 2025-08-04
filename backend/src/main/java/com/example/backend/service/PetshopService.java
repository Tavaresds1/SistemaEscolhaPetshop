package com.example.backend.service;

import com.example.backend.model.Petshop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PetshopService {

    public Petshop encontrarMelhorPetshop(String dataStr, int pequenos, int grandes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataStr, formatter);
        boolean fds = data.getDayOfWeek().getValue() >= 6;

        List<Petshop> petshops = List.of(
            new Petshop("Meu Canino Feliz", 2.0, 20.0, 40.0, 24.0, 48.0),
            new Petshop("Vai Rex", 1.7, 15.0, 50.0, 20.0, 55.0),
            new Petshop("ChowChawgas", 0.8, 30.0, 45.0, 30.0, 45.0)
        );

        return petshops.stream()
                .min(Comparator
                        .comparingDouble((Petshop p) -> p.calcularPrecoTotal(pequenos, grandes, fds))
                        .thenComparingDouble(Petshop::getDistancia))
                .orElse(null);
    }

    public double calcularPreco(Petshop petshop, String data, int pequenos, int grandes) {
        boolean fds = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .getDayOfWeek().getValue() >= 6;
        return petshop.calcularPrecoTotal(pequenos, grandes, fds);
    }
}