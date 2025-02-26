package com.example.client.modules.client.application.ports.out;

import com.example.client.modules.client.domain.ClientModel;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface ClientRepository {
    ClientModel save(ClientModel clientModel);

    ClientModel update(ClientModel clientModel, Long id);

    ClientModel findById(Long id);

    Page<ClientModel> findAll(Map<String, Object> params);

    void delete(Long id);
}