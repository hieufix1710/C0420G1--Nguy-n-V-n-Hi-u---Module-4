package com.example.service.imp;

import com.example.entity.UserRole;
import com.example.repository.UserRoleRepository;
import com.example.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImp implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void save(UserRole userRole) {
     userRoleRepository.save(userRole);
    }
}
