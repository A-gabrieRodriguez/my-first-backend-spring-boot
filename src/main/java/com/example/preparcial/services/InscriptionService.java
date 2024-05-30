package com.example.preparcial.services;

import com.example.preparcial.models.dtos.InscriptionCourseDTO;
import com.example.preparcial.models.entities.InscriptionCourse;

import java.util.List;

public interface InscriptionService {
    List<InscriptionCourse> FindAll();
    void AddInscriptioncourse(InscriptionCourseDTO inscription);
}
