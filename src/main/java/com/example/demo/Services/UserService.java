package com.example.demo.Services;

import com.example.demo.Entity.Conference;
import com.example.demo.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    User getUser(Long id);

    List<User>getAllUser();


    void deleteUser(User user);

    User updateUser(User user);

    long countUser();

    Optional<User> tryToSaveUser(String login, String email);

    void addUserToConference(User user, Conference clickedConference);

    void removeUserToConference(User user, Conference clickedConference);
}
