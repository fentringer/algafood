package com.algaworks.algafood.service;

import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.model.mapper.RestauranteMapper;
import com.algaworks.algafood.model.entity.Restaurante;
import com.algaworks.algafood.model.dto.RestauranteDTO;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;
    private final RestauranteMapper restauranteMapper;

    public RestauranteService(RestauranteRepository repository, RestauranteMapper restauranteMapper) {
        this.repository = repository;
        this.restauranteMapper = restauranteMapper;
    }

    public List<RestauranteDTO> listar() {
        List<Restaurante> Restaurantes = repository.findAll();

        return Restaurantes.stream().map(restauranteMapper::toDTO).collect(Collectors.toList());
    }

    public RestauranteDTO buscar(Long id) {
        Restaurante restaurante = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Não existe cadastro de Restaurante com código %d", id)));

        return restauranteMapper.toDTO(restaurante);
    }

    public RestauranteDTO salvar(RestauranteDTO restauranteDTO) {

        Restaurante restaurante = restauranteMapper.toEntity(restauranteDTO);
        restaurante = repository.save(restaurante);

        return restauranteMapper.toDTO(restaurante);
    }

    public RestauranteDTO atualizar(Long id, RestauranteDTO restauranteDTO) {
        Restaurante restaurante = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Restaurante não encontrado com o id %d", id)));
        BeanUtils.copyProperties(restauranteDTO, restaurante, "id");
        restaurante = repository.save(restaurante);


        return restauranteMapper.toDTO(restaurante);
    }

    public void remover(Long id) {
        Restaurante restaurante = repository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Restaurante não encontrado com o id %d", id)));
        try {
            repository.delete(restaurante);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Restaurante em uso, não pode ser removido.");
        }
    }
}
