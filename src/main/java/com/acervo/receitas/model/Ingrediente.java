package com.acervo.receitas.model;

import jakarta.persistence.Embeddable;

    @Embeddable
    public class Ingrediente {

        private String nome;
        private String descricao;
        private int quantidade;
        private String medida; // Ex: colher de sopa, xicara, mls....

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public String getMedida() {
            return medida;
        }

        public void setMedida(String medida) {
            this.medida = medida;
        }
    }
