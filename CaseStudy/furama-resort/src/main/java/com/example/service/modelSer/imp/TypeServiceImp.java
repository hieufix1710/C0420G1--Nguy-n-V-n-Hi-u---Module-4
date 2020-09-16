package com.example.service.modelSer.imp;


import com.example.entity.model.TypeService;
import com.example.repository.modelRepo.TypeServiceRepo;
import com.example.service.modelSer.ITypeService;
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
