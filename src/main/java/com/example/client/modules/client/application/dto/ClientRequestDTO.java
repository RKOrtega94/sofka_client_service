package com.example.client.modules.client.application.dto;

import com.example.client.modules.person.application.dto.PersonRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {
    @NotNull
    @NotBlank
    @Length(min = 3, max = 64)
    private String clientId;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 64)
    private String password;
    @Builder.Default
    private boolean status = true;
    @NotNull
    @Valid
    private PersonRequestDTO person;
}
