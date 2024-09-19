package com.acervo.receitas.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
    public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String descricaoPreparo;
    private int numeroPorcoes;

    @ManyToOne
    private Cozinheiro cozinheiro;

    @ManyToOne
    private Categoria categoria;

    @ElementCollection
    private List<Ingrediente> ingredientes;

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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricaoPreparo() {
        return descricaoPreparo;
    }

    public void setDescricaoPreparo(String descricaoPreparo) {
        this.descricaoPreparo = descricaoPreparo;
    }

    public Cozinheiro getCozinheiro() {
        return cozinheiro;
    }

    public void setCozinheiro(Cozinheiro cozinheiro) {
        this.cozinheiro = cozinheiro;
    }

    public int getNumeroPorcoes() {
        return numeroPorcoes;
    }

    public void setNumeroPorcoes(int numeroPorcoes) {
        this.numeroPorcoes = numeroPorcoes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
