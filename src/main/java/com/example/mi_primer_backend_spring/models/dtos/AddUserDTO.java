package com.example.mi_primer_backend_spring.models.dtos;

import com.example.mi_primer_backend_spring.models.entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDTO {

        private String nombre;
        private String apellido;
        private String password;
        private String email;
        private Role role;
        private Date fecha_contratacion;

}
