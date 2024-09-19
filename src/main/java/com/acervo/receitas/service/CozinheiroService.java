package com.acervo.receitas.service;

import com.acervo.receitas.dto.CozinheiroDTO;
import com.acervo.receitas.mapper.CozinheiroMapper;
import com.acervo.receitas.model.Cozinheiro;
import com.acervo.receitas.repository.CozinheiroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CozinheiroService {

    @Autowired
    private CozinheiroRepository cozinheiroRepository;

    @Autowired
    private CozinheiroMapper cozinheiroMapper;

    public CozinheiroDTO salvarCozinheiro (CozinheiroDTO cozinheiroDTO) {
        Cozinheiro cozinheiro = fromDTO(cozinheiroDTO);
        Cozinheiro novoCozinheiro = cozinheiroRepository.save(cozinheiro);
        return toDTO(novoCozinheiro);
    }

    public List<CozinheiroDTO> listarCozinheiros () {
        return cozinheiroRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CozinheiroDTO> buscarPorId(Long id) {
        return cozinheiroRepository.findById(id)
                .map(cozinheiroMapper::toDTO); // Converte a entidade Cozinheiro para CozinheiroDTO
    }

    public void deletarCozinheiro(Long id) {
        if (cozinheiroRepository.existsById(id)) {
            cozinheiroRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cozinheiro não encontrado");
        }
    }


    private CozinheiroDTO toDTO (Cozinheiro cozinheiro) {
        CozinheiroDTO dto = new CozinheiroDTO();
        dto.setId(cozinheiro.getId());
        dto.setNome(cozinheiro.getNome());
        dto.setDataIngresso(cozinheiro.getDataIngresso().toString());
        dto.setNomeFantasia(cozinheiro.getNomeFantasia());
        dto.setRestaurantesImportantes(dto.getRestaurantesImportantes());
        return dto;
    }

    private Cozinheiro fromDTO(CozinheiroDTO dto) {
        Cozinheiro cozinheiro = new Cozinheiro();
        cozinheiro.setNome(dto.getNome());
        cozinheiro.setDataIngresso(LocalDate.parse(dto.getDataIngresso()));
        cozinheiro.setNomeFantasia(dto.getNomeFantasia());
        cozinheiro.setRestaurantesImportantes(dto.getRestaurantesImportantes());
        return cozinheiro;
    }

}
