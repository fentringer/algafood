package com.algaworks.algafood.model.dto;

import com.algaworks.algafood.model.entity.Estado;

public class CidadeDTO {

    private String nome;
    private Estado estado;


    public CidadeDTO(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
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

