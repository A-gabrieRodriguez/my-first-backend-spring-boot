package com.example.mi_primer_backend_spring.repositories;

import com.example.mi_primer_backend_spring.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRole(String role);
}

