package com.acervo.receitas.dto;

import java.util.List;

public class ReceitaDTO {

        private Long id;
        private String nome;
        private String dataCriacao;
        private String descricaoPreparo;
        private int numeroPorcoes;
        private CategoriaDTO categoria;
        private List<IngredienteDTO> ingredientes;
        private Long cozinheiroId;

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

        public String getDataCriacao() {
            return dataCriacao;
        }

        public void setDataCriacao(String dataCriacao) {
            this.dataCriacao = dataCriacao;
        }

        public String getDescricaoPreparo() {
            return descricaoPreparo;
        }

        public void setDescricaoPreparo(String descricaoPreparo) {
            this.descricaoPreparo = descricaoPreparo;
        }

        public int getNumeroPorcoes() {
            return numeroPorcoes;
        }

        public void setNumeroPorcoes(int numeroPorcoes) {
            this.numeroPorcoes = numeroPorcoes;
        }

        public CategoriaDTO getCategoria() {
            return categoria;
        }

        public void setCategoria(CategoriaDTO categoria) {
            this.categoria = categoria;
        }

        public List<IngredienteDTO> getIngredientes() {
            return ingredientes;
        }

        public void setIngredientes(List<IngredienteDTO> ingredientes) {
            this.ingredientes = ingredientes;
        }

        public Long getCozinheiroId() {
            return cozinheiroId;
        }

        public void setCozinheiroId(Long cozinheiroId) {
            this.cozinheiroId = cozinheiroId;
        }
    }


