package com.algaworks.algafood.model.mapper;

import com.algaworks.algafood.model.entity.Permissao;
import com.algaworks.algafood.model.dto.PermissaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PermissaoMapper {

    PermissaoMapper INSTANCE = Mappers.getMapper(PermissaoMapper.class);

    PermissaoDTO toDTO(Permissao permissao);

    Permissao toEntity(PermissaoDTO permissaoDTO);
}

