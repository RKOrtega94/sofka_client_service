package com.example.client.modules.client.domain;

import com.example.client.modules.person.domain.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    private Long id;
    private String clientId;
    private String password;
    private boolean status;
    private PersonModel person;
}
