package com.acervo.receitas.controller;

import com.acervo.receitas.dto.CozinheiroDTO;
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
    public ResponseEntity<CozinheiroDTO> criarCozinheiro(@RequestBody CozinheiroDTO cozinheiroDTO) {
        CozinheiroDTO novoCozinheiroDTO = cozinheiroService.salvarCozinheiro(cozinheiroDTO);
        return new ResponseEntity<>(novoCozinheiroDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CozinheiroDTO>> listarCozinheiros() {
        return ResponseEntity.ok(cozinheiroService.listarCozinheiros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CozinheiroDTO> buscarCozinheiro(@PathVariable Long id) {
        return cozinheiroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCozinheiro(@PathVariable Long id) {
        cozinheiroService.deletarCozinheiro(id);
        return ResponseEntity.noContent().build();
    }
}


}// fim CozinheiroController
