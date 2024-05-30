package com.example.preparcial.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "UserXCourse")
public class InscriptionCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Llave de usuario
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "code")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "code")
    private Course course;

}
