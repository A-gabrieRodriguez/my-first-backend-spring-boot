package com.example.mi_primer_backend_spring.controllers;

import com.example.mi_primer_backend_spring.models.dtos.UserInfoDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserLoginDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserRegisterDTO;
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
    private UserService userService;

    //Validando usuario y contraseña para login
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

    //Obteniendo todos los usuarios
    @GetMapping("/usersAll")
    public ResponseEntity<?> readAllUsers(
            //CASOS de ERROR
            //NOTA: Recordar usar el DTO correcto en este caso usamos UserInfoDTO

            //CASO 1: Si el usuario no existe
            @Valid UserInfoDTO user, BindingResult validations) {
        if (validations.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //CASO 2: Si no hay usuarios
        List<UserInfoDTO> userslist = userService.readAllUsers();
        if (userslist == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //Si encontramos usuarios
        List<UserInfoDTO> response = userslist.stream()
                .map(u -> new UserInfoDTO(u.getId(), u.getName(), u.getEmail(), u.getRole(), u.isActive()))
                .toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Creando un nuevo usuario
    @PostMapping("/newusers")
    public ResponseEntity<?> register(
            //CASOS de ERROR
            @Valid @RequestBody UserRegisterDTO user, BindingResult validations) {
        //CASO 1: Si la petición no es válida
        if (validations.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //CASO 2: Si el usuario ya existe
        UserRegisterDTO userFound = new UserRegisterDTO(user.getId(), user.getNombre(), user.getApellido(),
                user.getGmail(), user.getPassword(), user.getRol(), user.getFecha_contratacion());

        //CASO 3: Si no se encuentra el usuario
        if (validations.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        //guardando el usuario
        userService.createUser(userFound);
        return new ResponseEntity<>("Se creo el usuario", HttpStatus.OK);
    }
}