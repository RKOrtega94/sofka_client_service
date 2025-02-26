package com.example.client.modules.person.application.dto;

import com.example.client.core.GenderEnum;
import jakarta.validation.constraints.Min;
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
public class PersonRequestDTO {
    @NotNull
    @NotBlank
    @Length(min = 3, max = 255)
    private String name;
    @NotNull
    private int age;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 20)
    private String identification;
    @NotNull
    @NotBlank
    @Length(min = 3, max = 500)
    private String address;
    @NotNull
    @NotBlank
    @Length(max = 20)
    private String phone;
    @NotNull
    private GenderEnum gender;
}
