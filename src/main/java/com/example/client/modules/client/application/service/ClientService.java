package com.example.client.modules.client.application.service;

import com.example.client.modules.client.application.adapters.ClientRequestMapper;
import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.application.dto.ClientResponseDTO;
import com.example.client.modules.client.application.dto.UpdateClientDTO;
import com.example.client.modules.client.application.ports.in.*;
import com.example.client.modules.client.application.ports.out.ClientRepository;
import com.example.client.modules.client.domain.ClientModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ClientService implements CreateClientUseCase, UpdateClientUseCase, RetrieveClientUseCase, RetrieveClientsUseCase, DeleteClientUseCase {
    private final ClientRequestMapper mapper;
    private final ClientRepository repository;

    @Override
    public ClientResponseDTO create(ClientRequestDTO dto) {
        ClientModel model = repository.save(mapper.toModel(dto));
        return mapper.toResponse(model);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ClientResponseDTO retrieve(Long id) {
        ClientModel model = repository.findById(id);
        return mapper.toResponse(model);
    }

    @Override
    public Page<ClientResponseDTO> retrieve(Map<String, Object> params) {
        return repository.findAll(params).map(mapper::toResponse);
    }

    @Override
    public ClientResponseDTO update(UpdateClientDTO dto, Long id) {
        ClientModel model = repository.update(mapper.toModel(dto), id);
        return mapper.toResponse(model);
    }
}
