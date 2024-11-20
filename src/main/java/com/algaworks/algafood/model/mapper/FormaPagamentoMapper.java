package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.entity.FormaPagamento;
import com.algaworks.algafood.model.dto.FormaPagamentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {

    FormaPagamentoMapper INSTANCE = Mappers.getMapper(FormaPagamentoMapper.class);

    FormaPagamentoDTO toDTO(FormaPagamento formaPagamento);

    FormaPagamento toEntity(FormaPagamentoDTO formaPagamentoDTO);
}

