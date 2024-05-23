package com.example.mi_primer_backend_spring.controllers;

import com.example.mi_primer_backend_spring.models.dtos.AddUserDTO;
import com.example.mi_primer_backend_spring.models.entities.User;
import com.example.mi_primer_backend_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

        @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody AddUserDTO addUserDTO) {
        userService.AddUser(addUserDTO);
        return ResponseEntity.ok("User added successfully");
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.FinAll();
    }



}