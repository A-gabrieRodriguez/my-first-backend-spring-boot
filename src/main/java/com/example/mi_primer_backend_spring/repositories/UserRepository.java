package com.example.mi_primer_backend_spring.repositories;

import  com.example.mi_primer_backend_spring.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
