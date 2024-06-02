package com.example.preparcial.controllers;

import com.example.preparcial.models.dtos.AddCourseDTO;
import com.example.preparcial.models.dtos.GetCourseByname;
import com.example.preparcial.models.entities.Course;
import com.example.preparcial.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseControllers {
    @Autowired
    private CourseService courseService;

    @GetMapping("/All-courses")
    public List<Course> getAllCourses() {
        return courseService.FindAll();
    }

    @PostMapping("/add-course")
    public ResponseEntity<String> AddCourse(@RequestBody AddCourseDTO addCourseDTO) {
        courseService.AddCourse(addCourseDTO);
        return ResponseEntity.ok("Course added successfully");
    }

    @PostMapping("/find-course")
    public ResponseEntity<Course> getCourseById(@RequestBody GetCourseByname course) {
        Course courseFound = courseService.FindById(course.getCourse().toString());
        if (courseFound != null) {
            return ResponseEntity.ok(courseFound);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
