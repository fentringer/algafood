package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.dto.EstadoDTO;
import com.algaworks.algafood.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    private final EstadoService service;

    public EstadoController(EstadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoDTO adicionar(@RequestBody EstadoDTO estadoDTO) {
        return service.salvar(estadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {
        return ResponseEntity.ok(service.atualizar(id, estadoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
