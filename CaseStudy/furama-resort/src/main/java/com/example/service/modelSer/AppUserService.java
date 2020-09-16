package com.example.service.modelSer;

import com.example.entity.user.AppUser;

public interface AppUserService {
    void save(AppUser appUser);
    long countId();
}
