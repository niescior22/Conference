package com.example.demo.Services;

import com.example.demo.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User getUser(Long id);

    List<User>getAllUser();


    void deleteUser(User user);

    User uptadeUser(User user);

    long countUser();

}
