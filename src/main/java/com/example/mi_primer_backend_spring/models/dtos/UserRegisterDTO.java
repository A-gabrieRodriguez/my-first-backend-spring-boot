package com.example.mi_primer_backend_spring.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String gmail;
    private String password;
    private String rol;
    private String fecha_contratacion;

}
