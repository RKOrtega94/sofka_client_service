package com.example.client.modules.client.application.service;

import com.example.client.modules.client.application.dto.ClientResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.client.modules.client.application.adapters.ClientRequestMapper;
import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.application.ports.out.ClientRepository;
import com.example.client.modules.client.domain.ClientModel;
import com.example.client.modules.person.application.adapters.mapper.PersonRequestMapper;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    private ClientService service;
    @MockitoBean
    private ClientRepository repository;
    @MockitoBean
    private ClientRequestMapper requestMapper;
    @MockitoBean
    private PersonRequestMapper personRequestMapper;

    @Test
    public void testCreateClient() {
        ClientRequestDTO clientDto = new ClientRequestDTO();
        clientDto.setClientId("identity");
        clientDto.setPassword("123456");

        ClientModel client = new ClientModel();
        client.setClientId("identity");
        client.setPassword("123456");

        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setId(client.getId());
        clientResponseDTO.setName("");
        clientResponseDTO.setPassword("123456");

        when(requestMapper.toModel(clientDto)).thenReturn(client);
        when(repository.save(client)).thenReturn(client);
        when(requestMapper.toResponse(client)).thenReturn(clientResponseDTO);

        ClientResponseDTO result = service.create(clientDto);

        assertNotNull(result);
        assertEquals(client.getId(), result.getId());
        verify(repository, times(1)).save(client);
    }
}
