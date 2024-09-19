package com.acervo.receitas.repository;

import com.acervo.receitas.model.Cozinheiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinheiroRepository extends JpaRepository<Cozinheiro, Long> {

    List<Cozinheiro> findBynome (String nome);
}
