package com.example.preparcial.services.ServicesImpl;


import com.example.preparcial.models.dtos.InscriptionCourseDTO;
import com.example.preparcial.models.entities.Course;
import com.example.preparcial.models.entities.InscriptionCourse;
import com.example.preparcial.models.entities.User;
import com.example.preparcial.reposiries.InscriptionCourseRepository;
import com.example.preparcial.services.CourseService;
import com.example.preparcial.services.InscriptionService;
import com.example.preparcial.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionCourseRepository inscriptionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @Override
    public List<InscriptionCourse> FindAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public void AddInscriptioncourse(InscriptionCourseDTO inscription) {

        User user = userService.FindById(inscription.getEmail());
        if (user == null) {
            throw new RuntimeException("Error en el usuario, no existe");
        }
        Course course = new Course();
        course = courseService.FindById(inscription.getCourse());
        if (course == null) {
            throw new RuntimeException("Error en el curso, no existe");
        }
        InscriptionCourse inscriptionCourse = new InscriptionCourse();
        inscriptionCourse.setUser(user);
        inscriptionCourse.setCourse(course);
        inscriptionRepository.save(inscriptionCourse);
    }
}
