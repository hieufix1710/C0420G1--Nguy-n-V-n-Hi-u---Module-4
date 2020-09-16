package com.example.service.modelSer;


import com.example.entity.model.TypeRent;
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
