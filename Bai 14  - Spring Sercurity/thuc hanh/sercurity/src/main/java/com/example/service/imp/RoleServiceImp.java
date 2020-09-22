package com.example.service.imp;

import com.example.entity.Role;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private   RoleRepository roleRepository;


    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
