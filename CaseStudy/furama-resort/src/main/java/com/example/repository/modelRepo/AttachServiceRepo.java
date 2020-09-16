package com.example.repository.modelRepo;


import com.example.entity.model.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttachServiceRepo extends JpaRepository<AttachService,Long> {

    @Query("select c from Contract  c where  c.customer.name like :search")
    Page<AttachService> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from Contract c")
    Page<AttachService> findAll(Pageable pageable,String search);
}
