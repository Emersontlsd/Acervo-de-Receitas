package com.acervo.receitas.dto;

import java.util.List;

public class LivroDTO {
    private Long id;
    private String titulo;
    private String codigoISBN;
    private Long editorId;
    private List<ReceitaDTO> receitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public Long getEditorId() {
        return editorId;
    }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
    }

    public List<ReceitaDTO> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaDTO> receitas) {
        this.receitas = receitas;
    }
}

