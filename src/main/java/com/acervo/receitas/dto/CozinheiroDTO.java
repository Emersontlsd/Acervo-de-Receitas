package com.acervo.receitas.dto;

import java.util.List;

public class CozinheiroDTO {
    private Long id;
    private String nome;
    private String dataIngresso;
    private String nomeFantasia;
    private List<String> restaurantesImportantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
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
}
