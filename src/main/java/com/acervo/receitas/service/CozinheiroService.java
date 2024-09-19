package com.acervo.receitas.service;

import com.acervo.receitas.model.Cozinheiro;
import com.acervo.receitas.repository.CozinheiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinheiroService {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    public Cozinheiro salvarCozinheiro (Cozinheiro cozinheiro ) {
        return cozinheiroRepository.save(cozinheiro);
    }

    public List<Cozinheiro> listarCozinheiros () {
        return cozinheiroRepository.findAll();
    }

    public Optional<Cozinheiro> buscarPorId(Long id) {
        return cozinheiroRepository.findById(id);
    }

    public void deletarCozinheiro (Long id) {
        cozinheiroRepository.deleteById(id);
    }

}
