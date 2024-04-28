package com.example.mi_primer_backend_spring.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioAllDTO {
    private String nombre;
    private String apellido;
    private String gmail;
    private String password;

}
