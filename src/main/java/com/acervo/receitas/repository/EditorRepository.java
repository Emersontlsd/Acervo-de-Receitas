package com.acervo.receitas.repository;

import com.acervo.receitas.model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository  extends JpaRepository<Editor, Long> {
}
