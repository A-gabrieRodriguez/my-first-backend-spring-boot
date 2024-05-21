package com.example.mi_primer_backend_spring.controllers;

import com.example.mi_primer_backend_spring.models.entities.User;
import com.example.mi_primer_backend_spring.repositories.UserRepositoy;
import com.example.mi_primer_backend_spring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserRepositoy userRepositoy;
    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) {

        userService.AddUser(user);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.FinAll();
    }

}