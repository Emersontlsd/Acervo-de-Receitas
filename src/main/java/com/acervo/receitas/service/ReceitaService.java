package com.acervo.receitas.service;

import com.acervo.receitas.model.Categoria;
import com.acervo.receitas.model.Receita;
import com.acervo.receitas.repository.CategoriaRepository;
import com.acervo.receitas.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;



    public Receita salvarReceita(Receita receita) {

        Optional<Categoria> categoriaExistente = categoriaRepository.findById(receita.getCategoria().getId());
        if (!categoriaExistente.isPresent()) {
            throw new IllegalArgumentException("Categoria não encontrada.");
        }
        receita.setCategoria(categoriaExistente.get());
        return receitaRepository.save(receita);
    }// fim salvarReceita

    public List<Receita> listarReceitas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarPorId(Long id) {
        return receitaRepository.findById(id);
    }

    public void deletarReceita(Long id) {
        receitaRepository.deleteById(id);
    }
} // fim classe
