package com.codegym.testspringboot.service.imp;

import com.codegym.testspringboot.model.User;
import com.codegym.testspringboot.repository.UserRepository;
import com.codegym.testspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void save(User user) {
       this.userRepository.save(user);
    }
}
