package com.acervo.receitas.service;

import com.acervo.receitas.model.Degustador;
import com.acervo.receitas.repository.DegustadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegustadorService {

    @Autowired
    private DegustadorRepository degustadorRepository;

    public Degustador salvarDegustador (Degustador degustador) {
        return degustadorRepository.save(degustador);
    }

    public List<Degustador> listarDegustador () {
       return degustadorRepository.findAll();
    }

    public Optional<Degustador> buscarPorId (Long id) {
        return degustadorRepository.findById(id);
    }

    public void deletarDegustador (Long id) {
        degustadorRepository.deleteById(id);
    }

}
