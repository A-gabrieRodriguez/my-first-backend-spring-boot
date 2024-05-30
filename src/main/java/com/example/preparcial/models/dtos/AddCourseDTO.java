package com.example.preparcial.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCourseDTO {
    private String course;
    private String description;
    private String professor;
    private String schedule;
}
