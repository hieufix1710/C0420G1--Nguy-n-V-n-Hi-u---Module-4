package com.example.customerrmanagerusei18n.service.imp;


import com.example.customerrmanagerusei18n.model.Customer;
import com.example.customerrmanagerusei18n.repository.CusRepo;
import com.example.customerrmanagerusei18n.service.CusSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CusSerImp implements CusSer {

    @Autowired
    private CusRepo cusRepo;

    @Override
    public List<Customer> findAll() {
        return cusRepo.findAll();
    }
}
