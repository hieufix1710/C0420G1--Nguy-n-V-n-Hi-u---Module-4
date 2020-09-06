package com.codegym.testspringboot.service;

import com.codegym.testspringboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User>  findAll();
    User findById(int id);
    void save(User user);


}
