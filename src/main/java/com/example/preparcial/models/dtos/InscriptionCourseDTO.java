package com.example.preparcial.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InscriptionCourseDTO {
    private String username;
    private String email;
    private String course;
}
