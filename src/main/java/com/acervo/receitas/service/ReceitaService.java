package com.acervo.receitas.service;

import com.acervo.receitas.dto.CategoriaDTO;
import com.acervo.receitas.dto.IngredienteDTO;
import com.acervo.receitas.dto.ReceitaDTO;
import com.acervo.receitas.mapper.ReceitaMapper;
import com.acervo.receitas.model.Categoria;
import com.acervo.receitas.model.Cozinheiro;
import com.acervo.receitas.model.Ingrediente;
import com.acervo.receitas.model.Receita;
import com.acervo.receitas.repository.CategoriaRepository;
import com.acervo.receitas.repository.CozinheiroRepository;
import com.acervo.receitas.repository.ReceitaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

    @Service
    public class ReceitaService {

        @Autowired
        private ReceitaRepository receitaRepository;

        private CozinheiroRepository cozinheiroRepository;

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Autowired
        private ReceitaMapper receitaMapper;

    public ReceitaDTO salvarReceita (ReceitaDTO receitaDTO) {
        Receita receita = fromDTO(receitaDTO);
        Receita novaReceita = receitaRepository.save(receita);
        return toDTO(novaReceita);
    }


    public List<ReceitaDTO> listarReceitas() {
        return receitaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ReceitaDTO toDTO(Receita receita) {
        ReceitaDTO dto = new ReceitaDTO();
        dto.setId(receita.getId());
        dto.setNome(receita.getNome());
        dto.setDataCriacao(receita.getDescricaoPreparo().toString());
        dto.setDescricaoPreparo(receita.getDescricaoPreparo());
        dto.setNumeroPorcoes(receita.getNumeroPorcoes());

        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(receita.getCategoria().getId());
        categoriaDTO.setNome(receita.getCategoria().getNome());
        dto.setCategoria(categoriaDTO);

        List<IngredienteDTO> ingredientesDTO = receita.getIngredientes().stream()
                .map(ingrediente -> {
                    IngredienteDTO ingredienteDTO = new IngredienteDTO();
                    ingredienteDTO.setId(ingrediente.getId());
                    ingredienteDTO.setNome(ingrediente.getNome());
                    ingredienteDTO.setDescricao(ingrediente.getDescricao());
                    ingredienteDTO.setQuantidade(ingrediente.getQuantidade());
                    ingredienteDTO.setUnidadeMedida(ingredienteDTO.getUnidadeMedida());
                    return ingredienteDTO;
                })
                        .collect(Collectors.toList());

        dto.setIngredientes(ingredientesDTO);
        dto.setCozinheiroId(receita.getCozinheiro().getId());

        return dto;

    } // fim ReceitaDTO toDTO

    private Receita fromDTO(ReceitaDTO dto) {
        Receita receita = new Receita();
        receita.setNome(dto.getNome());
        receita.setDataCriacao(LocalDate.parse(dto.getDataCriacao()));
        receita.setDescricaoPreparo(dto.getDescricaoPreparo());
        receita.setNumeroPorcoes(dto.getNumeroPorcoes());

        Cozinheiro cozinheiro = cozinheiroRepository.findById(dto.getCozinheiroId())
                .orElseThrow(() -> new RuntimeException("Cozinheiro não encontrado"));
        receita.setCozinheiro(cozinheiro);

        Categoria categoria = categoriaRepository.findById(dto.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        receita.setCategoria(categoria);

        List<Ingrediente> ingredientes = dto.getIngredientes().stream()
                .map(ingredienteDTO -> {
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setId(ingredienteDTO.getId());
                    ingrediente.setNome(ingredienteDTO.getNome());
                    ingrediente.setDescricao(ingredienteDTO.getDescricao());
                    ingrediente.setQuantidade(ingredienteDTO.getQuantidade());
                    ingrediente.setMedida(ingredienteDTO.getUnidadeMedida());
                    return ingrediente;
                })
                .collect(Collectors.toList());
        receita.setIngredientes(ingredientes);
        return receita;
    } // fim Change access modifier

        public Optional<ReceitaDTO> buscarPorId(Long id) {
            return receitaRepository.findById(id)
                    .map(receitaMapper::toDTO); // Converte a entidade Receita em ReceitaDTO
        }

        public void deletarReceita(Long id) {
            if (receitaRepository.existsById(id)) {
                receitaRepository.deleteById(id);
            } else {
                throw new EntityNotFoundException("Receita não encontrada");
            }
        }




    } // fim classe
