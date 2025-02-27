package com.example.client.modules.client.application.ports.in;

import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.application.dto.ClientResponseDTO;
import com.example.client.modules.client.domain.ClientModel;

/**
 * This interface represents the use case for creating a new client.
 * It is part of the application layer and is responsible for handling the business logic
 * related to creating a new client.
 */
public interface CreateClientUseCase {
    /**
     * Executes the use case to create a new client.
     *
     * @param dto The DTO containing the client's request data.
     * @return The DTO representing the created client.
     */
    ClientResponseDTO create(ClientRequestDTO dto);
}
