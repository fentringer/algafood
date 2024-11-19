package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinhaService {

    private final CozinhaRepository repository;

    public CozinhaService(CozinhaRepository repository) {
        this.repository = repository;
    }

    public List<Cozinha> listar() {
        return repository.findAll();
    }

    public Optional<Cozinha> buscar(Long id) {
        return repository.findById(id);
    }

    public Cozinha salvar(Cozinha cozinha) {
        return repository.save(cozinha);
    }

    public Optional<Cozinha> atualizar(Long id, Cozinha novaCozinha) {
        return buscar(id).map(cozinhaAtual -> {
            BeanUtils.copyProperties(novaCozinha, cozinhaAtual, "id");
            return repository.save(cozinhaAtual);
        });
    }

    public Optional<Boolean> remover(Long id) {
        return repository.findById(id)
                .map(cozinha -> {
                    try {
                        repository.delete(cozinha);
                        return true;
                    } catch (DataIntegrityViolationException e) {
                        throw new EntidadeEmUsoException("Cozinha de ID " + id + " não pode ser removida, pois está em uso.");
                    }
                });
    }

}
