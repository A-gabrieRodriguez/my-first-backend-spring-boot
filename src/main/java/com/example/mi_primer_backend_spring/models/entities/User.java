package com.example.mi_primer_backend_spring.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data genera los getters y setters
//@AllArgsConstructor genera el constructor con todos los atributos
//@NoArgsConstructor genera el constructor vacio
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // el archivo de la base de datos se llama users
    private String id;
    private String nombre;
    private String apellido;
    private String gmail;
    @JsonIgnore //para que no se muestre en la password
    private String password;
    private String rol;
    private String fecha_contratacion;
    private Boolean active;

}
