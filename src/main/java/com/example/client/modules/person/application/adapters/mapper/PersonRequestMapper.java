package com.example.client.modules.person.application.adapters.mapper;

import com.example.client.modules.person.application.dto.PersonRequestDTO;
import com.example.client.modules.person.domain.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonRequestMapper {
    PersonRequestMapper INSTANCE = Mappers.getMapper(PersonRequestMapper.class);

    @Mapping(target = "id", ignore = true)
    PersonModel toModel(PersonRequestDTO dto);
}
