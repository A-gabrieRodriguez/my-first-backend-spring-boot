package com.example.mi_primer_backend_spring.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.mi_primer_backend_spring.models.entities.Role;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllUsersDTO {
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private Role role;
    private Date fecha_contratacion;
}
