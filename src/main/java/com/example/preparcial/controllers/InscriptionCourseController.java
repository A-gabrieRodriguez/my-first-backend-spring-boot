package com.example.preparcial.controllers;

import com.example.preparcial.models.dtos.InscriptionCourseDTO;
import com.example.preparcial.models.entities.InscriptionCourse;
import com.example.preparcial.models.entities.User;
import com.example.preparcial.services.InscriptionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.preparcial.models.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@CrossOrigin("*")
public class InscriptionCourseController {
    @Autowired
    private InscriptionService inscriptionService;
    @GetMapping("/All-inscription")
    public List<InscriptionCourse> getAllInscriptionCourse() {
        //Buscando y devolviendo los cursos inscritos
        return inscriptionService.FindAll();
    }

    @PostMapping("/add-inscription")
    public void AddInscriptionCourse(@RequestBody InscriptionCourseDTO addInscriptionCourseDTO) {
        inscriptionService.AddInscriptioncourse(addInscriptionCourseDTO);
    }

}
