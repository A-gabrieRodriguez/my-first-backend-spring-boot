package com.example.mi_primer_backend_spring.services;

import com.example.mi_primer_backend_spring.models.entities.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<Role> FinAll ();
    void AddRole(Role role);
    Role FindById(String id);
}
