package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.CidadeMapper;
import com.algaworks.algafood.model.entity.Cidade;
import com.algaworks.algafood.model.dto.CidadeDTO;
import com.algaworks.algafood.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {

    private final CidadeRepository repository;
    private final CidadeMapper cidadeMapper;

    public CidadeService(CidadeRepository repository, CidadeMapper cidadeMapper) {
        this.repository = repository;
        this.cidadeMapper = cidadeMapper;
    }

    public List<CidadeDTO> listar() {
        List<Cidade> cidades = repository.findAll();

        return cidades.stream()
                .map(cidadeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CidadeDTO buscar(Long id) {
        Cidade cidade = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cidade com código %d", id)));

        return cidadeMapper.toDTO(cidade);
    }

    public CidadeDTO salvar(CidadeDTO cidadeDTO) {

        Cidade cidade = cidadeMapper.toEntity(cidadeDTO);
        cidade = repository.save(cidade);

        return cidadeMapper.toDTO(cidade);
    }

    public CidadeDTO atualizar(Long id, CidadeDTO cidadeDTO) {
        Cidade cidade = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cidade não encontrada com o id %d", id)));
        BeanUtils.copyProperties(cidadeDTO, cidade, "id");
        cidade = repository.save(cidade);

        return cidadeMapper.toDTO(cidade);
    }

    public void remover(Long id) {
        Cidade cidade = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Cidade não encontrada com o id %d", id)));
        try {
            repository.delete(cidade);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Cidade em uso, não pode ser removida.");
        }
    }
}
