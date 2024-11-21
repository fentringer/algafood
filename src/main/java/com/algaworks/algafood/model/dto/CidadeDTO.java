package com.algaworks.algafood.model.dto;

import com.algaworks.algafood.model.entity.Estado;

public class CidadeDTO {

    private Long id;
    private String nome;
    private Estado estado;


    public CidadeDTO(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

