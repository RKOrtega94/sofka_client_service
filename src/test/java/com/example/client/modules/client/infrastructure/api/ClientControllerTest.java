package com.example.client.modules.client.infrastructure.api;

import com.example.client.core.GenderEnum;
import com.example.client.modules.client.application.dto.ClientRequestDTO;
import com.example.client.modules.client.domain.ClientModel;
import com.example.client.modules.client.infrastructure.persistence.JpaClientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.client.modules.person.application.dto.PersonRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private JpaClientRepository jpaClientRepository;

    @BeforeEach
    void setUp() {
        jpaClientRepository.deleteAll();
    }

    @Test
    void testClientControllerCreateClienteRequest() {
        PersonRequestDTO personDto = new PersonRequestDTO();
        personDto.setName("test");
        personDto.setAge(20);
        personDto.setIdentification("12324567890");
        personDto.setAddress("test 123");
        personDto.setPhone("1234567890");
        personDto.setGender(GenderEnum.MALE);
        ClientRequestDTO clientDto = new ClientRequestDTO();
        clientDto.setClientId("identity");
        clientDto.setPassword("123456");
        clientDto.setPerson(personDto);

        ResponseEntity<ClientModel> createResponse = testRestTemplate.postForEntity("/api/clientes", clientDto, ClientModel.class);
        ClientModel createdClient = ((ClientModel) createResponse.getBody());
        assertNotNull(createdClient);
        assertEquals(HttpStatus.CREATED, createResponse.getStatusCode());
    }
}
