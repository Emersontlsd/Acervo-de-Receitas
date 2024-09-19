package com.acervo.receitas.controller;

import com.acervo.receitas.dto.ReceitaDTO;
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
    public ResponseEntity<ReceitaDTO> criarReceita (@RequestBody ReceitaDTO receitaDTO ) {
        ReceitaDTO novaReceitaDTO = receitaService.salvarReceita(receitaDTO);
        return new ResponseEntity<>(novaReceitaDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> listarReceitas() {
        return ResponseEntity.ok(receitaService.listarReceitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> buscarReceita (@PathVariable Long id) {
        return receitaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable Long id) {
        receitaService.deletarReceita(id);
        return ResponseEntity.noContent().build();
    }

}// fim classe
