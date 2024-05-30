package com.example.preparcial.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;
    private String course;
    private String description;
    private String professor;
    private String schedule;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<InscriptionCourse> inscriptionXCourse;
}
