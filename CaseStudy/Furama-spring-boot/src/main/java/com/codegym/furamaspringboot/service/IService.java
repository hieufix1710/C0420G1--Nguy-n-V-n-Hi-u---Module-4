package com.codegym.furamaspringboot.service;


import com.codegym.furamaspringboot.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService {
    void saveService(Service service);
    void deleteService(Long id);
    Service findById(Long id);
    Page<Service> findAll(Pageable pageable,String search);
    List<Service> findAll();
}
