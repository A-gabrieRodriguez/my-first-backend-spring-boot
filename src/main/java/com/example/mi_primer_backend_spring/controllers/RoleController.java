package com.example.mi_primer_backend_spring.controllers;

import com.example.mi_primer_backend_spring.models.entities.Role;
import com.example.mi_primer_backend_spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.FinAll();
    }

    /*
    //una manera de traer el usuario
    @GetMapping("/roles/find-id/{roleName}")
    public ResponseEntity<UUID> getRoleIdByName(@PathVariable String roleName) {
        UUID roleId = roleService.FindById(roleName);
        if (roleId != null) {
            return ResponseEntity.ok(roleId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    @PostMapping("/roles/search")
    public ResponseEntity<Role> getRoleIdByName(@RequestBody Map<String, String> requestBody) {
        String roleName = requestBody.get("role");
      //  UUID roleId = roleService.FindById(roleName);
        Role roleId = roleService.FindById(roleName);
        if (roleId != null) {
            return ResponseEntity.ok(roleId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
