package com.example.service.modelSer.imp;

import com.example.entity.user.AppUser;
import com.example.repository.userRepo.AppUserRepository;
import com.example.service.modelSer.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserSerImp implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public long countId() {
        return appUserRepository.countAppUserId();
    }
}
