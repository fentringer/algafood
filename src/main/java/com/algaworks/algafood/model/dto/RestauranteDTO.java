package com.algaworks.algafood.model.dto;

import com.algaworks.algafood.model.entity.Cozinha;
import java.math.BigDecimal;


public class RestauranteDTO {
    private Long id;

    private String nome;

    private BigDecimal taxaFrete;

    private Cozinha cozinha;

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

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    public Cozinha getCozinha() {
        return cozinha;
    }

    public void setCozinha(Cozinha cozinha) {
        this.cozinha = cozinha;
    }
}
