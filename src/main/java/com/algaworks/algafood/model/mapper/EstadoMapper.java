package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.entity.Estado;
import com.algaworks.algafood.model.dto.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    EstadoMapper INSTANCE = Mappers.getMapper(EstadoMapper.class);

    EstadoDTO toDTO(Estado estado);

    Estado toEntity(EstadoDTO estadoDTO);
}

