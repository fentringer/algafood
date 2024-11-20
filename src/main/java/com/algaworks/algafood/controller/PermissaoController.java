package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.dto.PermissaoDTO;
import com.algaworks.algafood.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permissoes")
public class PermissaoController {

    private final PermissaoService service;

    public PermissaoController(PermissaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PermissaoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PermissaoDTO adicionar(@RequestBody PermissaoDTO permissaoDTO) {
        return service.salvar(permissaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissaoDTO> atualizar(@PathVariable Long id, @RequestBody PermissaoDTO permissaoDTO) {
        return ResponseEntity.ok(service.atualizar(id, permissaoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
