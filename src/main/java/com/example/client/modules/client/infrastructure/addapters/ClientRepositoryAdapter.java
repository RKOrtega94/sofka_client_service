package com.example.client.modules.client.infrastructure.addapters;

import com.example.client.core.utils.BuildPaginationRequest;
import com.example.client.modules.client.application.ports.out.ClientRepository;
import com.example.client.modules.client.domain.ClientModel;
import com.example.client.modules.client.infrastructure.addapters.mapper.ClientMapper;
import com.example.client.modules.client.infrastructure.persistence.ClientEntity;
import com.example.client.modules.client.infrastructure.persistence.JpaClientRepository;
import com.example.client.modules.person.domain.PersonModel;
import com.example.client.modules.person.infrastructure.persistence.PersonEntity;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {
    private final ClientMapper mapper;
    private final JpaClientRepository jpa;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientModel save(ClientModel clientModel) {
        ClientEntity entity = mapper.toEntity(clientModel);
        entity.setPassword(passwordEncoder.encode(clientModel.getPassword()));
        return mapper.toModel(jpa.save(entity));
    }

    @Override
    public ClientModel update(ClientModel clientModel, Long id) {
        ClientEntity entity = jpa.findById(id).orElseThrow(EntityExistsException::new);
        PersonEntity personEntity = entity.getPerson();
        mapper.updateEntity(clientModel, entity);
        entity.setId(id);
        entity.setPerson(personEntity);
        if (clientModel.getPassword() != null) entity.setPassword(passwordEncoder.encode(clientModel.getPassword()));
        return mapper.toModel(jpa.save(entity));
    }

    @Override
    public ClientModel findById(Long id) {
        return mapper.toModel(jpa.findById(id).orElseThrow(EntityExistsException::new));
    }

    @Override
    public Page<ClientModel> findAll(Map<String, Object> params) {
        PageRequest pageRequest = BuildPaginationRequest.build(params);
        return jpa.findAll(pageRequest).map(mapper::toModel);
    }

    @Override
    public void delete(Long id) {
        jpa.findById(id).orElseThrow(EntityExistsException::new);
        jpa.deleteById(id);
    }
}
