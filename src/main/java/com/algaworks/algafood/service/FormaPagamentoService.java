package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.FormaPagamentoMapper;
import com.algaworks.algafood.model.entity.FormaPagamento;
import com.algaworks.algafood.model.dto.FormaPagamentoDTO;
import com.algaworks.algafood.repository.FormaPagamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository repository;
    private final FormaPagamentoMapper formaPagamentoMapper;

    public FormaPagamentoService(FormaPagamentoRepository repository, FormaPagamentoMapper formaPagamentoMapper) {
        this.repository = repository;
        this.formaPagamentoMapper = formaPagamentoMapper;
    }

    public List<FormaPagamentoDTO> listar() {
        List<FormaPagamento> formaPagamentos = repository.findAll();

        return formaPagamentos.stream()
                .map(formaPagamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FormaPagamentoDTO buscar(Long id) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de formaPagamento com código %d", id)));

        return formaPagamentoMapper.toDTO(formaPagamento);
    }

    public FormaPagamentoDTO salvar(FormaPagamentoDTO formaPagamentoDTO) {

        FormaPagamento formaPagamento = formaPagamentoMapper.toEntity(formaPagamentoDTO);
        formaPagamento = repository.save(formaPagamento);

        return formaPagamentoMapper.toDTO(formaPagamento);
    }

    public FormaPagamentoDTO atualizar(Long id, FormaPagamentoDTO formaPagamentoDTO) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("FormaPagamento não encontrada com o id %d", id)));
        BeanUtils.copyProperties(formaPagamentoDTO, formaPagamento, "id");
        formaPagamento = repository.save(formaPagamento);

        return formaPagamentoMapper.toDTO(formaPagamento);
    }

    public void remover(Long id) {
        FormaPagamento formaPagamento = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("FormaPagamento não encontrada com o id %d", id)));
        try {
            repository.delete(formaPagamento);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("FormaPagamento em uso, não pode ser removida.");
        }
    }
}
