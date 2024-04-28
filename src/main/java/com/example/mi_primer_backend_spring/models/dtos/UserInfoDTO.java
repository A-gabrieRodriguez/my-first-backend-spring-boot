package com.example.mi_primer_backend_spring.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private String id;
    private String name;
    private String email;
    private String role;
    private boolean active;
}
