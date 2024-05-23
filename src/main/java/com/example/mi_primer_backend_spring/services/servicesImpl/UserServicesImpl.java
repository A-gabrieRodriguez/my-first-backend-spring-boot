package com.example.mi_primer_backend_spring.services.servicesImpl;

import com.example.mi_primer_backend_spring.models.dtos.AddUserDTO;
import com.example.mi_primer_backend_spring.models.entities.Role;
import com.example.mi_primer_backend_spring.models.entities.User;
import com.example.mi_primer_backend_spring.repositories.RoleRepository;
import com.example.mi_primer_backend_spring.repositories.UserRepository;
import com.example.mi_primer_backend_spring.services.RoleService;
import com.example.mi_primer_backend_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> FinAll() {
        //Buscando y devolviendo los usuario
        return userRepository.findAll();
    }

    @Override
    public void AddUser(AddUserDTO addUserDTO) {
        Role role = roleService.FindById(addUserDTO.getRole().getRole());
        if (role == null) {
            throw new RuntimeException("Error en el rol, no existe");
        }

        User user = new User();
        user.setNombre(addUserDTO.getNombre());
        user.setApellido(addUserDTO.getApellido());
        user.setEmail(addUserDTO.getEmail());
        user.setPassword(addUserDTO.getPassword());
        user.setFecha_contratacion(addUserDTO.getFecha_contratacion());
        user.setRole(role);

        userRepository.save(user);
    }
}
