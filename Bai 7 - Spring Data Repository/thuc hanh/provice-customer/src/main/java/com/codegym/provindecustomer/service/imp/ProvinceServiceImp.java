package com.codegym.provindecustomer.service.imp;

import com.codegym.provindecustomer.model.Province;
import com.codegym.provindecustomer.repository.ProvinceRepo;
import com.codegym.provindecustomer.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImp implements ProvinceService {
    @Autowired
    ProvinceRepo provinceRepo;


    @Override
    public List<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public void update(Long id, Province Province) {

    }

    @Override
    public void delete(Long id) {
           provinceRepo.deleteById(id);
    }

    @Override
    public void save(Province Customer) {
              provinceRepo.save(Customer);
    }

    @Override
    public Province findById(Long id) {
        return provinceRepo.findById(id).orElse(null);
    }
}
