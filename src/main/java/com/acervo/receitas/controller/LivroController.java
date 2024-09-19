package com.acervo.receitas.controller;

import com.acervo.receitas.model.Livro;
import com.acervo.receitas.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> criarLivro (@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivro (@PathVariable Long id) {
        Optional<Livro> livro = livroService.buscarPorID(id);
        return  livro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro (@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

}// fim LivroController
