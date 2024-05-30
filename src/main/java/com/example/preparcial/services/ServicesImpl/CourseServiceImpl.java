package com.example.preparcial.services.ServicesImpl;

import com.example.preparcial.models.dtos.AddCourseDTO;
import com.example.preparcial.models.entities.Course;
import com.example.preparcial.reposiries.CourseRepository;
import com.example.preparcial.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> FindAll() {
        return courseRepository.findAll();
    }

    @Override
    public void AddCourse(AddCourseDTO course) {
        Course newCourse = new Course();
        newCourse.setCourse(course.getCourse());
        newCourse.setProfessor(course.getProfessor());
        newCourse.setDescription(course.getDescription());
        newCourse.setSchedule(course.getSchedule());
        courseRepository.save(newCourse);
    }
}
