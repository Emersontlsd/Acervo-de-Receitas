package com.acervo.receitas.repository;

import com.acervo.receitas.model.Receita;
import com.acervo.receitas.model.TesteDegustacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TesteDegustacaoRepository extends JpaRepository<TesteDegustacao, Long> {
    List<TesteDegustacao> findByReceita (Receita receita);
}
