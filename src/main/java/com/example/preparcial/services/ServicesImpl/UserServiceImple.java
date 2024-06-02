package com.example.preparcial.services.ServicesImpl;

import com.example.preparcial.models.dtos.AddUserDTO;
import com.example.preparcial.models.entities.InscriptionCourse;
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
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
    }

    @Override
    public User FindById(String email) {
        /*
        //Otra forma de hacerlo
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Email: " + email);
                return user;
            }
        }
        */
        System.out.println("El email que llega a esta cosa es : " + email);
        User user = userRepository.findByEmail(email);
        return user;
    }
}
