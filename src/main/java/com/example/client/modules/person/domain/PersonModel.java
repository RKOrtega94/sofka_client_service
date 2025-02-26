package com.example.client.modules.person.domain;

import com.example.client.core.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {
    private Long id;
    private String name;
    private GenderEnum gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
    private boolean status;
}
