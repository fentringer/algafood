package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.EstadoMapper;
import com.algaworks.algafood.model.entity.Estado;
import com.algaworks.algafood.model.dto.EstadoDTO;
import com.algaworks.algafood.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    private final EstadoRepository repository;
    private final EstadoMapper estadoMapper;

    public EstadoService(EstadoRepository repository, EstadoMapper estadoMapper) {
        this.repository = repository;
        this.estadoMapper = estadoMapper;
    }

    public List<EstadoDTO> listar() {
        List<Estado> Estados = repository.findAll();

        return Estados.stream().map(estadoMapper::toDTO).collect(Collectors.toList());
    }

    public EstadoDTO buscar(Long id) {
        Estado estado = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de Estado com código %d", id)
                ));

        return estadoMapper.toDTO(estado);
    }

    public EstadoDTO salvar(EstadoDTO estadoDTO) {

        Estado estado = estadoMapper.toEntity(estadoDTO);
        estado = repository.save(estado);

        return estadoMapper.toDTO(estado);
    }

    public EstadoDTO atualizar(Long id, EstadoDTO estadoDTO) {
        Estado estado = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Estado não encontrado com o id %d", id)));
        BeanUtils.copyProperties(estadoDTO, estado, "id");
        estado = repository.save(estado);


        return estadoMapper.toDTO(estado);
    }

    public void remover(Long id) {
        Estado estado = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Estado não encontrado com o id %d", id)));
        try {
            repository.delete(estado);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Estado em uso, não pode ser removida.");
        }
    }
}
