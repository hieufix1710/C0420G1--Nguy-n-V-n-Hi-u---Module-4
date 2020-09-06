package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.Service;
import com.codegym.furamaspringboot.repository.ServiceRepo;
import com.codegym.furamaspringboot.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements IService {

    @Autowired
    private ServiceRepo serviceRepo;
    @Override
    public void saveService(Service service) {
         serviceRepo.save(service);
    }

    @Override
    public void deleteService(Long id) {
           serviceRepo.deleteById(id);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Service> findAll(Pageable pageable, String search) {
        if ("".equals(search)){
            return serviceRepo.findAll(pageable);
        }else {
            String temp="%"+search+"%";
            return serviceRepo.findAllBySearch(pageable,temp);
        }

    }

    @Override
    public List<Service> findAll() {
        return serviceRepo.findAll();
    }
}
