package com.example.service.modelSer.imp;


import com.example.entity.model.Service;
import com.example.repository.modelRepo.ServiceRepo;
import com.example.service.modelSer.IService;
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
