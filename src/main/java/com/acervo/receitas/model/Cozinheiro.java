package com.acervo.receitas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


    @Entity
    public class Cozinheiro {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String rg;
        private String nome;
        private LocalDate dataIngresso;
        private double salario;
        private String nomeFantasia;

        @ElementCollection
        private List<String> restaurantesImportantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

        public List<String> getRestaurantesImportantes() {
            return restaurantesImportantes;
        }

        public void setRestaurantesImportantes(List<String> restaurantesImportantes) {
            this.restaurantesImportantes = restaurantesImportantes;
        }
    }// fim classe
