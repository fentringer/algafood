package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.dto.FormaPagamentoDTO;
import com.algaworks.algafood.service.FormaPagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/formaPagamentos")
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    public FormaPagamentoController(FormaPagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FormaPagamentoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamentoDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoDTO adicionar(@RequestBody FormaPagamentoDTO formaPagamentoDTO) {
        return service.salvar(formaPagamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamentoDTO> atualizar(@PathVariable Long id, @RequestBody FormaPagamentoDTO formaPagamentoDTO) {
        return ResponseEntity.ok(service.atualizar(id, formaPagamentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
