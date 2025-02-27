package com.example.client.modules.client.application.ports.in;

import com.example.client.modules.client.application.dto.ClientResponseDTO;
import com.example.client.modules.client.domain.ClientModel;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Interface for retrieving clients.
 * This interface defines a contract for retrieving clients.
 * Implementations of this interface should handle the logic for retrieving clients.
 */
public interface RetrieveClientsUseCase {
    /**
     * Retrieves a list of clients based on the provided parameters.
     *
     * @param params A map containing the parameters for filtering and retrieving clients.
     * @return A page of client models matching the provided parameters.
     */
    Page<ClientResponseDTO> retrieve(Map<String, Object> params);
}
