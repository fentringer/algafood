package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.dto.CidadeDTO;
import com.algaworks.algafood.model.entity.Cidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);

    CidadeDTO toDTO(Cidade cidade);

    Cidade toEntity(CidadeDTO cidadeDTO);
}

