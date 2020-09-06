package com.ckodegym.validatesinginform.service.imp;

import com.ckodegym.validatesinginform.model.User;
import com.ckodegym.validatesinginform.repository.UserRepository;
import com.ckodegym.validatesinginform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(Long id, User User) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(User customer) {

    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}
