package com.icekiwi.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icekiwi.banking.models.User;
import com.icekiwi.banking.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // get user list
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }

    // get user info
    public User getUserInfo(String Matricule) {

        User user = userRepository.findById(Matricule).orElseThrow();

        return user;
    }

    // delete user account
    public User revokeUserAccount(String Matricule) {
        return null;
    }

}
