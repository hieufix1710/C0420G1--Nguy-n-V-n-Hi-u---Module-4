package com.example.service.imp;

import com.example.entity.User;
import com.example.repository.AppUserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerImp implements UserService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public void save(User user) {
        appUserRepository.save(user);
    }


}
