package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.CozinhaMapper;
import com.algaworks.algafood.model.entity.Cozinha;
import com.algaworks.algafood.model.dto.CozinhaDTO;
import com.algaworks.algafood.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CozinhaService {

    private final CozinhaRepository repository;
    private final CozinhaMapper cozinhaMapper;

    public CozinhaService(CozinhaRepository repository, CozinhaMapper cozinhaMapper) {
        this.repository = repository;
        this.cozinhaMapper = cozinhaMapper;
    }

    public List<CozinhaDTO> listar() {
        List<Cozinha> cozinha = repository.findAll();

        return cozinha.stream()
                .map(cozinhaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CozinhaDTO buscar(Long id) {
        Cozinha cozinha = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha com código %d", id)));

        return cozinhaMapper.toDTO(cozinha);
    }

    public CozinhaDTO salvar(CozinhaDTO cozinhaDTO) {

        Cozinha cozinha = cozinhaMapper.toEntity(cozinhaDTO);
        cozinha = repository.save(cozinha);

        return cozinhaMapper.toDTO(cozinha);
    }

    public CozinhaDTO atualizar(Long id, CozinhaDTO cozinhaDTO) {
        Cozinha cozinha = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cozinha não encontrada com o id %d", id)));
        BeanUtils.copyProperties(cozinhaDTO, cozinha, "id");
        cozinha = repository.save(cozinha);

        return cozinhaMapper.toDTO(cozinha);
    }

    public void remover(Long id) {
        Cozinha cozinha = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cozinha não encontrada com o id %d", id)));
        try {
            repository.delete(cozinha);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Cozinha em uso, não pode ser removida.");
        }
    }
}
