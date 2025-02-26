package com.example.client.modules.client.application.ports.in;

import com.example.client.modules.client.domain.ClientModel;

/**
 * Interface for creating a new client.
 * This interface defines a contract for creating a new client.
 * Implementations of this interface should handle the logic for creating a new client.
 */
public interface RetrieveClientUseCase {
    /**
     * Retrieves a client by its ID.
     *
     * @param id The ID of the client to retrieve.
     * @return The client model corresponding to the provided ID.
     */
    ClientModel retrieve(Long id);
}
