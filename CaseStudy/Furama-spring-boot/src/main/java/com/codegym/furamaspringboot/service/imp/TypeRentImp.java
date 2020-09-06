package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.TypeRent;
import com.codegym.furamaspringboot.repository.TypeRentRepo;
import com.codegym.furamaspringboot.service.ITypeRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRentImp implements ITypeRent {

    @Autowired
    private TypeRentRepo typeRentRepo;
    @Override
    public Page<TypeRent> findAllTypeRent(Pageable pageable, String search) {
        return typeRentRepo.findAllTypeRent(pageable, search);
    }

    @Override
    public void saveTypeRent(TypeRent typeRent) {
            typeRentRepo.save(typeRent);
    }

    @Override
    public void deleteTypeRent(Long id) {
            typeRentRepo.deleteById(id);
    }

    @Override
    public TypeRent findById(Long id) {
        return typeRentRepo.findById(id).orElse(null);
    }

    @Override
    public List<TypeRent> findAllTypeRent() {
        return typeRentRepo.findAll();
    }
}
