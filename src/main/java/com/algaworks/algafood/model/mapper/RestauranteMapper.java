package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.entity.Restaurante;
import com.algaworks.algafood.model.dto.RestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    RestauranteDTO toDTO(Restaurante restaurante);

    Restaurante toEntity(RestauranteDTO restauranteDTO);
}

