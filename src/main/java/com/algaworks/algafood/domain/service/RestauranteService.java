package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public List<Restaurante> listar() {
        return repository.findAll();
    }

    public Optional<Restaurante> buscar(Long id) {
        return repository.findById(id);
    }

    public Restaurante salvar(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    public Optional<Restaurante> atualizar(Long id, Restaurante novoRestaurante) {
        return buscar(id).map(restauranteAtual -> {
            BeanUtils.copyProperties(novoRestaurante, restauranteAtual, "id");
            return repository.save(restauranteAtual);
        });
    }

    public Optional<Boolean> remover(Long id) {
        return repository.findById(id)
                .map(restaurante -> {
                    try {
                        repository.delete(restaurante);
                        return true;
                    } catch (DataIntegrityViolationException e) {
                        throw new EntidadeEmUsoException("Restaurante de ID " + id + " não pode ser removida, pois está em uso.");
                    }
                });
    }

}
