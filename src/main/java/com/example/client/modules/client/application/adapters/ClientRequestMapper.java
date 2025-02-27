package com.example.client.modules.client.application.adapters;

import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.application.dto.ClientResponseDTO;
import com.example.client.modules.client.application.dto.UpdateClientDTO;
import com.example.client.modules.client.domain.ClientModel;
import com.example.client.modules.person.application.adapters.mapper.PersonRequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PersonRequestMapper.class)
public interface ClientRequestMapper {
    ClientRequestMapper INSTANCE = Mappers.getMapper(ClientRequestMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    ClientModel toModel(ClientRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    ClientModel toModel(UpdateClientDTO dto);


    @Mapping(target = "name", source = "person.name")
    @Mapping(target = "address", source = "person.address")
    @Mapping(target = "phone", source = "person.phone")
    ClientResponseDTO toResponse(ClientModel model);
}
