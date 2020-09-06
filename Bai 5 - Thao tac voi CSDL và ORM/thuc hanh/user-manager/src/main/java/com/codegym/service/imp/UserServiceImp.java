package com.codegym.service.imp;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.repository.imp.UserRepositoryImp;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImp implements UserService {

    @Autowired
    private UserRepositoryImp userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> save(List<User> user) {
        return userRepository.save(user);
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User customer) {

    }

    @Override
    public void delete(List<User> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
