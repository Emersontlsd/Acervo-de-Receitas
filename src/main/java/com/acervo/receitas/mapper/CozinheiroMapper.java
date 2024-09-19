package com.acervo.receitas.mapper;

import com.acervo.receitas.dto.CozinheiroDTO;
import com.acervo.receitas.model.Cozinheiro;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CozinheiroMapper {

    // Converte a entidade Cozinheiro em CozinheiroDTO
    public CozinheiroDTO toDTO(Cozinheiro cozinheiro) {
        CozinheiroDTO dto = new CozinheiroDTO();
        dto.setId(cozinheiro.getId());
        dto.setNome(cozinheiro.getNome());
        dto.setDataIngresso(cozinheiro.getDataIngresso().toString());
        dto.setSalario(cozinheiro.getSalario());

        // Se o cozinheiro for renomado, adicionar o nome fantasia e os restaurantes
        if (cozinheiro.getNomeFantasia() != null) {
            dto.setNomeFantasia(cozinheiro.getNomeFantasia());
        }

        return dto;
    }

    // Converte o DTO de Cozinheiro em uma entidade Cozinheiro
    public Cozinheiro fromDTO(CozinheiroDTO dto) {
        Cozinheiro cozinheiro = new Cozinheiro();
        cozinheiro.setId(dto.getId());
        cozinheiro.setNome(dto.getNome());

        // Converter a data de ingresso de String para LocalDate
        if (dto.getDataIngresso() != null) {
            cozinheiro.setDataIngresso(LocalDate.parse(dto.getDataIngresso()));
        }

        cozinheiro.setSalario(dto.getSalario());

        // Definir nome fantasia e restaurantes se aplicável
        if (dto.getNomeFantasia() != null) {
            cozinheiro.setNomeFantasia(dto.getNomeFantasia());
        }


        return cozinheiro;
    }
}
