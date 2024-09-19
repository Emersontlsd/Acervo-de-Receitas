package com.acervo.receitas.repository;

import com.acervo.receitas.model.Degustador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegustadorRepository extends JpaRepository<Degustador, Long> {
}
