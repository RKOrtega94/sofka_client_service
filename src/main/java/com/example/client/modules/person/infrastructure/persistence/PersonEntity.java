package com.example.client.modules.person.infrastructure.persistence;

import com.example.client.core.GenderEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "people")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    private int age;
    private String identification;
    private String address;
    private String phone;
    @Builder.Default
    private boolean status = true;
}
