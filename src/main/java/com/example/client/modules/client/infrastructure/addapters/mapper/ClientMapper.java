package com.example.client.modules.client.infrastructure.addapters.mapper;

import com.example.client.modules.client.domain.ClientModel;
import com.example.client.modules.client.infrastructure.persistence.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity toEntity(ClientModel model);

    ClientModel toModel(ClientEntity entity);

    void updateEntity(ClientModel model, @MappingTarget ClientEntity entity);
}
