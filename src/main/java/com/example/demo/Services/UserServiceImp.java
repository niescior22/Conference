package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository repository;


    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);

    }

    @Override
    public User uptadeUser(User user) {
        return repository.save(user);
    }

    @Override
    public long countUser() {
        return repository.count();
    }


}

