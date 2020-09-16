package com.example.repository.modelRepo;


import com.example.entity.model.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeServiceRepo extends JpaRepository<TypeService,Long> {

    @Query("select c from TypeRent  c where c.name like :search")
    Page<TypeService> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from TypeRent  c")
    Page<TypeService> findAllTypeService(Pageable pageable,String search);
}
