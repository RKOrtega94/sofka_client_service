package com.example.client.modules.client.application.service;

import com.example.client.modules.client.application.adapters.ClientRequestMapper;
import com.example.client.modules.client.application.dto.ClientRequestDTO;
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
    public ClientModel create(ClientRequestDTO dto) {
        return repository.save(mapper.toModel(dto));
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public ClientModel retrieve(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<ClientModel> retrieve(Map<String, Object> params) {
        return repository.findAll(params);
    }

    @Override
    public ClientModel update(UpdateClientDTO dto, Long id) {
        return repository.update(mapper.toModel(dto), id);
    }
}
