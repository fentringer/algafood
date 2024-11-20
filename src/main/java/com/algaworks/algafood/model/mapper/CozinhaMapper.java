package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.entity.Cozinha;
import com.algaworks.algafood.model.dto.CozinhaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CozinhaMapper {

    CozinhaMapper INSTANCE = Mappers.getMapper(CozinhaMapper.class);

    CozinhaDTO toDTO(Cozinha cozinha);

    Cozinha toEntity(CozinhaDTO cozinhaDTO);
}

