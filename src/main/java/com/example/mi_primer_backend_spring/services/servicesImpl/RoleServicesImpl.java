package com.example.mi_primer_backend_spring.services.servicesImpl;

import com.example.mi_primer_backend_spring.models.entities.Role;
import com.example.mi_primer_backend_spring.repositories.RoleRepository;
import com.example.mi_primer_backend_spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServicesImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> FinAll() {
        System.out.println("Llegamos a qui pero esta cosa no sirve");
        return roleRepository.findAll();
    }

    @Override
    public void AddRole(Role role) {

    }

    @Override
    public Role FindById(String roleName) {
        Role role = roleRepository.findByRole(roleName);
        if(role != null) {
            return role;
        } else {
            return null;
        }
    }
}
