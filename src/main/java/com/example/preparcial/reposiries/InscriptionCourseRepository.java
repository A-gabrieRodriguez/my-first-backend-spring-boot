package com.example.preparcial.reposiries;

import com.example.preparcial.models.entities.InscriptionCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InscriptionCourseRepository extends JpaRepository<InscriptionCourse, UUID>{

}
