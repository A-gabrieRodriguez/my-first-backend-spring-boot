package com.example.mi_primer_backend_spring.services;

import com.example.mi_primer_backend_spring.models.dtos.UserInfoDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserLoginDTO;
import com.example.mi_primer_backend_spring.models.dtos.UserRegisterDTO;
import com.example.mi_primer_backend_spring.models.entities.User;

import java.util.List;

public interface UserService {

    public void createUser(UserRegisterDTO user);
    public List<UserInfoDTO> readAllUsers();
    public User login(String id, String password);
    public void changePassword(String id, String password, String newPassword);
    public void toggleUser(String id);

}
