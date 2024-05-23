package com.example.mi_primer_backend_spring.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.text.DateFormat;

//@Data genera los getters y setters
//@AllArgsConstructor genera el constructor con todos los atributos
//@NoArgsConstructor genera el constructor vacio
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    // el archivo de la base de datos se llama users
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String gmail;

    @JsonIgnore //para que no se muestre en la password
    @Column(name="password")
    private String password;

    @Column(name="rol")
    private String rol;

    @Column(name="fecha_contratacion")
    private Date fecha_contratacion;

}
