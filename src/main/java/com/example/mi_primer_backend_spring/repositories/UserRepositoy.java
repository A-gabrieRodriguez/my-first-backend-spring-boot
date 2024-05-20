package com.example.mi_primer_backend_spring.repositories;

import  com.example.mi_primer_backend_spring.models.entities.User;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepositoy extends JpaRepository<User, String> {

}
