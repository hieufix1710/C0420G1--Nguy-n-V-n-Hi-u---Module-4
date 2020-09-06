package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.Customer;
import com.codegym.furamaspringboot.model.TypeService;
import com.codegym.furamaspringboot.repository.TypeServiceRepo;
import com.codegym.furamaspringboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImp implements ITypeService {

    @Autowired
    private TypeServiceRepo typeServiceRepo;
    @Override
    public Page<TypeService> findAllTypeService(Pageable pageable, String search) {
        return typeServiceRepo.findAllBySearch(pageable, search);
    }

    @Override
    public void saveTypeService(TypeService typeService) {
            typeServiceRepo.save(typeService);
    }

    @Override
    public void deleteTypeService(Long id) {
           typeServiceRepo.deleteById(id);
    }

    @Override
    public TypeService findById(Long id) {
        return typeServiceRepo.findById(id).orElse(null);
    }

    @Override
    public List<TypeService> findAllTypeService() {
        return typeServiceRepo.findAll();
    }
}
