package com.example.mi_primer_backend_spring.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SinginDTO {
    //datos que seran llamados en el body para una petición post para logearse
    private String nombre;
    private String email;
    private String password;
}
