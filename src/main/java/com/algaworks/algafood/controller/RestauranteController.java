package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.dto.RestauranteDTO;
import com.algaworks.algafood.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteDTO adicionar(@RequestBody RestauranteDTO restauranteDTO) {
        return service.salvar(restauranteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        return ResponseEntity.ok(service.atualizar(id, restauranteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
