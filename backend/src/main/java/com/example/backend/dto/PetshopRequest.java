package com.example.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PetshopRequest {

    // A anotação @NotBlank impede que o campo seja nulo ou vazio.
    // A anotação @Pattern garante que o formato da data seja "dd/MM/yyyy".
    @NotBlank(message = "A data não pode estar vazia.")
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "A data deve estar no formato dd/MM/yyyy.")
    private String data;

    // A anotação @Min garante que o valor seja no mínimo 0.
    @Min(value = 0, message = "A quantidade de cães pequenos não pode ser negativa.")
    private int qtdPequenos;

    // A anotação @Min garante que o valor seja no mínimo 0.
    @Min(value = 0, message = "A quantidade de cães grandes não pode ser negativa.")
    private int qtdGrandes;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getQtdPequenos() {
        return qtdPequenos;
    }

    public void setQtdPequenos(int qtdPequenos) {
        this.qtdPequenos = qtdPequenos;
    }

    public int getQtdGrandes() {
        return qtdGrandes;
    }

    public void setQtdGrandes(int qtdGrandes) {
        this.qtdGrandes = qtdGrandes;
    }
}
