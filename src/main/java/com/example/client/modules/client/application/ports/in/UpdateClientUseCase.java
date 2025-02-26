package com.example.client.modules.client.application.ports.in;

import com.example.client.modules.client.application.dto.UpdateClientDTO;
import com.example.client.modules.client.domain.ClientModel;

/**
 * This interface represents the use case for updating an existing client.
 * It is part of the application layer and is responsible for handling the business logic
 * related to updating an existing client.
 */
public interface UpdateClientUseCase {
    /**
     * Executes the use case to update an existing client.
     *
     * @param dto The DTO containing the updated client data.
     * @param id  The ID of the client to be updated.
     * @return The DTO representing the updated client.
     */
    ClientModel update(UpdateClientDTO dto, Long id);
}
