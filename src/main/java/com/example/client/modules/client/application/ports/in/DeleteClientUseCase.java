package com.example.client.modules.client.application.ports.in;

/**
 * This interface defines the contract for the DeleteClientUseCase.
 * The DeleteClientUseCase is responsible for deleting a client from the system.
 */
public interface DeleteClientUseCase {
    /**
     * Deletes a client from the system.
     *
     * @param id The ID of the client to be deleted.
     */
    void delete(Long id);
}
