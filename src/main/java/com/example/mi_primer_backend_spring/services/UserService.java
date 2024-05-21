package com.example.mi_primer_backend_spring.services;

import com.example.mi_primer_backend_spring.models.entities.User;

import java.util.List;

public interface UserService {
    List<User> FinAll ();
    void AddUser(User user);
}
