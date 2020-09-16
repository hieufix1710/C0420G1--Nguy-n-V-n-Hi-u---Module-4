package com.example.service.modelSer.imp;

import com.example.entity.user.AppRole;
import com.example.repository.userRepo.AppRoleRepository;
import com.example.service.modelSer.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleSerImp implements AppRoleService {

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Override
    public AppRole findByRoleName(String name) {
        return appRoleRepository.findByRoleName(name);
    }
}
