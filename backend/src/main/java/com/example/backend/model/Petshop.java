package com.example.backend.model;

public class Petshop {
    private String nome;
    private double distancia;
    private double precoPequenoDiaUtil;
    private double precoGrandeDiaUtil;
    private double precoPequenoFds;
    private double precoGrandeFds;

    public Petshop(String nome, double distancia, double precoPequenoDiaUtil, double precoGrandeDiaUtil, double precoPequenoFds, double precoGrandeFds) {
        this.nome = nome;
        this.distancia = distancia;
        this.precoPequenoDiaUtil = precoPequenoDiaUtil;
        this.precoGrandeDiaUtil = precoGrandeDiaUtil;
        this.precoPequenoFds = precoPequenoFds;
        this.precoGrandeFds = precoGrandeFds;
    }

    public double calcularPrecoTotal(int pequenos, int grandes, boolean fimDeSemana) {
        if (fimDeSemana) {
            return pequenos * precoPequenoFds + grandes * precoGrandeFds;
        } else {
            return pequenos * precoPequenoDiaUtil + grandes * precoGrandeDiaUtil;
        }
    }

    public String getNome() { return nome; }
    public double getDistancia() { return distancia; }
}
