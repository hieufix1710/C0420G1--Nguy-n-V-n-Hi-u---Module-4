package com.example.repository.modelRepo;


import com.example.entity.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Long> {
    @Query ("select c from Service  c where c.name like :search")
    Page<Service> findAllBySearch(Pageable page, String search);
}
