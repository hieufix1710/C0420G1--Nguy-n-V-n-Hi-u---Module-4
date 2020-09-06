package com.codegym.provindecustomer.service;

import com.codegym.provindecustomer.model.Province;


import java.util.List;

public interface ProvinceService  {
    List<Province> findAll();
    void update(Long id, Province Province);
    void delete(Long id);
    void save(Province Customer);
    Province findById(Long id);
}
