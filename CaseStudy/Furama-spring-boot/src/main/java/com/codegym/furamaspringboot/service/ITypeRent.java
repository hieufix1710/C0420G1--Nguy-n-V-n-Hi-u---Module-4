package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.Customer;
import com.codegym.furamaspringboot.model.TypeRent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ITypeRent  {
    Page<TypeRent> findAllTypeRent (Pageable pageable, String search);
    void saveTypeRent(TypeRent TypeRent);
    void deleteTypeRent(Long id);
    TypeRent findById(Long id);

    List<TypeRent> findAllTypeRent();
}
