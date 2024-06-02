package com.example.preparcial.services;

import com.example.preparcial.models.dtos.AddCourseDTO;
import com.example.preparcial.models.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> FindAll();
    void AddCourse(AddCourseDTO course);
    Course FindById(String course);

}
