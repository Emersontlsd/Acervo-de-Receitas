package com.acervo.receitas.controller;

import com.acervo.receitas.model.Receita;
import com.acervo.receitas.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> criarReceita (@RequestBody Receita receita ) {
        Receita novaReceita = receitaService.salvarReceita(receita);
        return new ResponseEntity<>(novaReceita, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok(receitaService.listarReceitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscarReceita (@PathVariable Long id) {
        Optional<Receita> receita = receitaService.buscarPorId(id);
        return receita.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable Long id) {
        receitaService.deletarReceita(id);
        return ResponseEntity.noContent().build();
    }

}// fim classe
