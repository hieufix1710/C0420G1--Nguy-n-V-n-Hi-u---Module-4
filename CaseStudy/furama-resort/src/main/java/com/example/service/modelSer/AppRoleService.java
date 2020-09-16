package com.example.service.modelSer;

import com.example.entity.user.AppRole;

public interface AppRoleService {
    AppRole findByRoleName (String name);
}
