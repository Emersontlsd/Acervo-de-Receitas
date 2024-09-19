package com.acervo.receitas.service;

import com.acervo.receitas.model.Livro;
import com.acervo.receitas.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvarLivro (Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros () {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorID (Long id) {
        return livroRepository.findById(id);
    }

    public void deletarLivro (Long id) {
        livroRepository.deleteById(id);
    }

}
