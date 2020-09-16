package com.example.service.modelSer;


import com.example.entity.model.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ITypeService  {
    Page<TypeService> findAllTypeService(Pageable pageable, String search);
    void saveTypeService(TypeService typeService);
    void deleteTypeService(Long id);

    TypeService findById(Long id);

    List<TypeService> findAllTypeService ();
}
