package com.example.preparcial.services.ServicesImpl;

import com.example.preparcial.models.dtos.AddUserDTO;
import com.example.preparcial.reposiries.UserRepository;
import com.example.preparcial.services.UserService;
import com.example.preparcial.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> FindAll() {
        return userRepository.findAll();
    }

    @Override
    public void AddUser(AddUserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
    }
}
