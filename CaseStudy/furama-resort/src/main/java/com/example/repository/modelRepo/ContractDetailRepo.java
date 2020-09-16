package com.example.repository.modelRepo;


import com.example.entity.model.DetailContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractDetailRepo extends JpaRepository<DetailContract,Long> {

    @Query("select c from Contract  c where  c.customer.name like :search")
    Page<DetailContract> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from Contract c")
    Page<DetailContract> findAll(Pageable pageable,String search);
}
