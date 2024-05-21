package com.example.mi_primer_backend_spring.services.servicesImpl;

import com.example.mi_primer_backend_spring.models.entities.User;
import com.example.mi_primer_backend_spring.repositories.UserRepositoy;
import com.example.mi_primer_backend_spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserService  {

    @Autowired
    private UserRepositoy UserRepositoy;

    @Override
    public List<User> FinAll() {
        //Buscando y devolviendo los usuario
        return UserRepositoy.findAll();
    }

    @Override
    public void AddUser(User user) {
        UserRepositoy.save(user);
    }
}
