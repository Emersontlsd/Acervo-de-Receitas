package com.acervo.receitas.repository;

import com.acervo.receitas.model.Categoria;
import com.acervo.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    List<Receita> findByNome (String nome);
    List<Receita> findByCategoria (Categoria categoria);

}
