package com.acervo.receitas.controller;

import com.acervo.receitas.model.Cozinheiro;
import com.acervo.receitas.service.CozinheiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cozinheiros")
public class CozinheiroController {

    @Autowired
    private CozinheiroService cozinheiroService;

    @PostMapping
    public ResponseEntity<Cozinheiro> criarCozinheiro (@RequestBody Cozinheiro cozinheiro) {
        Cozinheiro novoCozinheiro = cozinheiroService.salvarCozinheiro(cozinheiro);
        return new ResponseEntity<>(novoCozinheiro, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cozinheiro>> listarCozinheiros() {
        return ResponseEntity.ok(cozinheiroService.listarCozinheiros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinheiro> buscarCozinheiro(@PathVariable Long id) {
        Optional<Cozinheiro> cozinheiro = cozinheiroService.buscarPorId(id);
        return cozinheiro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCozinheiro (@PathVariable Long id) {
        cozinheiroService.deletarCozinheiro(id);
        return ResponseEntity.noContent().build();
    }

}// fim CozinheiroController
