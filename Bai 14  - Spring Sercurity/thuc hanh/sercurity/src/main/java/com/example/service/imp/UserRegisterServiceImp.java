package com.example.service.imp;

import com.example.entity.UserRegister;
import com.example.repository.UserRegisterRepository;
import com.example.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImp implements UserRegisterService {
    @Autowired
    private UserRegisterRepository userRegisterRepository;
    @Override
    public void save(UserRegister userRegister) {
        userRegisterRepository.save(userRegister);

    }
}
