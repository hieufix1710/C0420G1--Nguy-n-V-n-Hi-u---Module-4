package com.example.repository.modelRepo;


import com.example.entity.model.TypeRent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeRentRepo extends JpaRepository<TypeRent,Long> {
    @Query ("select c from TypeRent  c where c.name like :search")
    Page<TypeRent> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from TypeRent  c")
    Page<TypeRent> findAllTypeRent(Pageable pageable,String search);
}
