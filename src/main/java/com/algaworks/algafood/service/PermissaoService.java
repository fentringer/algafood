package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.PermissaoMapper;
import com.algaworks.algafood.model.entity.Permissao;
import com.algaworks.algafood.model.dto.PermissaoDTO;
import com.algaworks.algafood.repository.PermissaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissaoService {

    private final PermissaoRepository repository;
    private final PermissaoMapper permissaoMapper;

    public PermissaoService(PermissaoRepository repository, PermissaoMapper permissaoMapper) {
        this.repository = repository;
        this.permissaoMapper = permissaoMapper;
    }

    public List<PermissaoDTO> listar() {
        List<Permissao> permissaos = repository.findAll();

        return permissaos.stream()
                .map(permissaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PermissaoDTO buscar(Long id) {
        Permissao permissao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de permissao com código %d", id)));

        return permissaoMapper.toDTO(permissao);
    }

    public PermissaoDTO salvar(PermissaoDTO permissaoDTO) {

        Permissao permissao = permissaoMapper.toEntity(permissaoDTO);
        permissao = repository.save(permissao);

        return permissaoMapper.toDTO(permissao);
    }

    public PermissaoDTO atualizar(Long id, PermissaoDTO permissaoDTO) {
        Permissao permissao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Permissao não encontrada com o id %d", id)));
        BeanUtils.copyProperties(permissaoDTO, permissao, "id");
        permissao = repository.save(permissao);

        return permissaoMapper.toDTO(permissao);
    }

    public void remover(Long id) {
        Permissao permissao = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Permissao não encontrada com o id %d", id)));
        try {
            repository.delete(permissao);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Permissao em uso, não pode ser removida.");
        }
    }
}
