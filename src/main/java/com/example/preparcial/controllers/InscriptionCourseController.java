package com.example.preparcial.controllers;

import com.example.preparcial.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.preparcial.models.entities.Course;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InscriptionCourseController {
    private String user;
    private String course;
}
