package com.example.phonesmanagerwthajax.service;

import com.example.phonesmanagerwthajax.model.SmartPhones;

public interface SmartPhoneService {
    Iterable<SmartPhones> findAll();
    SmartPhones findById(Long id);
    SmartPhones save(SmartPhones phone);
    void remove(Long id);
}
