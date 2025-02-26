package com.example.client.modules.client.infrastructure.api;

import com.example.client.core.utils.BaseResponse;
import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.application.dto.UpdateClientDTO;
import com.example.client.modules.client.application.ports.in.*;
import com.example.client.modules.client.domain.ClientModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientes")
public class ClientController {
    private final CreateClientUseCase createClientUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final RetrieveClientUseCase retrieveClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;
    private final RetrieveClientsUseCase retrieveClientsUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<BaseResponse<ClientModel>> createClient(@RequestBody @Valid ClientRequestDTO dto) {
        return ResponseEntity.created(URI.create("/api/clientes")).body(BaseResponse.<ClientModel>builder().message("Client created successfully").data(createClientUseCase.create(dto)).build());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BaseResponse<ClientModel>> updateClient(@PathVariable Long id, @RequestBody @Valid UpdateClientDTO dto) {
        return ResponseEntity.ok().body(BaseResponse.<ClientModel>builder().message("Client updated successfully").data(updateClientUseCase.update(dto, id)).build());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BaseResponse<ClientModel>> getClient(@PathVariable Long id) {
        return ResponseEntity.ok().body(BaseResponse.<ClientModel>builder().message("Client retrieved successfully").data(retrieveClientUseCase.retrieve(id)).build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        deleteClientUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<BaseResponse<Page<ClientModel>>> getAllClients(@RequestParam Map<String, Object> params) {
        return ResponseEntity.ok().body(BaseResponse.<Page<ClientModel>>builder().message("Clients retrieved successfully").data(retrieveClientsUseCase.retrieve(params)).build());
    }
}
