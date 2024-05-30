package com.example.preparcial.reposiries;

import com.example.preparcial.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID>{
}
