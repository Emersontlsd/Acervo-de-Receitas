package com.acervo.receitas.dto;

public class TesteDegustacaoDTO {
    private Long id;
    private Long receitaId;
    private Long degustadorId;
    private String data;
    private int nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(Long receitaId) {
        this.receitaId = receitaId;
    }

    public Long getDegustadorId() {
        return degustadorId;
    }

    public void setDegustadorId(Long degustadorId) {
        this.degustadorId = degustadorId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
