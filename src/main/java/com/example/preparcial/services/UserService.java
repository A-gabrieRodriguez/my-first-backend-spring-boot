package com.example.preparcial.services;

import com.example.preparcial.models.dtos.AddUserDTO;
import com.example.preparcial.models.entities.InscriptionCourse;
import com.example.preparcial.models.entities.User;

import java.util.List;

public interface UserService {
    List<User> FindAll();
    void AddUser(AddUserDTO user);
    User FindById(String person);
}
