package com.example.mi_primer_backend_spring.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.UUID;

//@Data genera los getters y setters
//@AllArgsConstructor genera el constructor con todos los atributos
//@NoArgsConstructor genera el constructor vacio
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    // el archivo de la base de datos se llama users
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private UUID id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="email")
    private String email;

    @JsonIgnore //para que no se muestre en la password
    @Column(name="password")
    private String password;

    @Column(name="fecha_contratacion")
    private Date fecha_contratacion;

    // Relacion con la tabla role, idRole es el nombre de la columna
    // en la tabla user en la BASE DE DATOS
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")//idRole es el nombre de la columna en la tabla user de la base de datos
    private Role role;

    // Constructor sin id
    public User(String nombre, String apellido, String email, String password,Role role ,Date fecha_contratacion) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fecha_contratacion = fecha_contratacion;
    }
}
