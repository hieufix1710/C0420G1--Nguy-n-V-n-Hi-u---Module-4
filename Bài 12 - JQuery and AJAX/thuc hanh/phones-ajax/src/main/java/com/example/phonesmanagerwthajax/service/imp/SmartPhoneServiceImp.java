package com.example.phonesmanagerwthajax.service.imp;

import com.example.phonesmanagerwthajax.model.SmartPhones;
import com.example.phonesmanagerwthajax.repository.SmartPhoneRepo;
import com.example.phonesmanagerwthajax.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartPhoneServiceImp implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepo smartPhoneRepo;

    @Override
    public Iterable<SmartPhones> findAll() {
        return smartPhoneRepo.findAll();
    }

    @Override
    public SmartPhones findById(Long id) {
        return smartPhoneRepo.findById(id).orElse(null);
    }

    @Override
    public SmartPhones save(SmartPhones phone) {
        return smartPhoneRepo.save(phone);
    }

    @Override
    public void remove(Long id) {
         smartPhoneRepo.deleteById(id);
    }
}
