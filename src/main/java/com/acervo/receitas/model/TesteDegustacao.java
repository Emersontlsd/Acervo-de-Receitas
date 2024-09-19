package com.acervo.receitas.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
    public class TesteDegustacao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDate data;
        private int nota;

        @ManyToOne
        private Receita receita;

        @ManyToOne
        private Degustador degustador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Degustador getDegustador() {
        return degustador;
    }

    public void setDegustador(Degustador degustador) {
        this.degustador = degustador;
    }
}// fim classe
