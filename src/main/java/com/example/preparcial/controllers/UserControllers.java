package com.example.preparcial.controllers;

import com.example.preparcial.models.dtos.AddUserDTO;
import com.example.preparcial.services.UserService;
import com.example.preparcial.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserControllers {
    @Autowired
    private UserService userService;
    @GetMapping("/All-users")
    public List<User> getAllUsers() {
        return userService.FindAll();
    }
    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody AddUserDTO addUserDTO) {
        userService.AddUser(addUserDTO);
        return ResponseEntity.ok("User added successfully");
    }

}
