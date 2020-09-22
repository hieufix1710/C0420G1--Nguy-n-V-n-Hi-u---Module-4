package com.example.service.imp;

import com.example.entity.User;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerImp implements UserService {
    @Autowired
    private com.example.repository.UserRepository UserRepository;
    @Override
    public void save(User user) {
        UserRepository.save(user);
    }


}
