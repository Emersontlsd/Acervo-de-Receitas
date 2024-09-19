package com.acervo.receitas.mapper;

import com.acervo.receitas.dto.ReceitaDTO;
import com.acervo.receitas.model.Receita;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReceitaMapper {

    public ReceitaDTO toDTO(Receita receita) {
        ReceitaDTO dto = new ReceitaDTO();
        dto.setId(receita.getId());
        dto.setNome(receita.getNome());
        dto.setDataCriacao(receita.getDataCriacao().toString());
        // Adicione o restante das conversões
        return dto;
    }

    public Receita fromDTO(ReceitaDTO dto) {
        Receita receita = new Receita();
        receita.setId(dto.getId());
        receita.setNome(dto.getNome());
        receita.setDataCriacao(LocalDate.parse(dto.getDataCriacao()));
        // Adicione o restante das conversões
        return receita;
    }

}
