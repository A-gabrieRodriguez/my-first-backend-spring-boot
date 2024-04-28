package com.example.mi_primer_backend_spring.controllers;

import com.example.mi_primer_backend_spring.models.dtos.UserLoginDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserRegisterDTO;
import com.example.mi_primer_backend_spring.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/login")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserLoginDTO user, BindingResult validations) {
        if (validations.hasErrors()) {
            return ResponseEntity.badRequest().body(validations.getAllErrors());
        }
        userService.login(user.getId(), user.getPassword());
        if(userService.login(user.getId(), user.getPassword()) == null){
            return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
        }
        return ResponseEntity.ok("Usuario logueado");

    }


}