package com.example.repository.modelRepo;

import com.example.entity.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepo extends JpaRepository<Contract,Long> {

    @Query ("select c from Contract  c where  c.customer.name like :search")
    Page<Contract> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from Contract c")
    Page<Contract> findAll(Pageable pageable,String search);

}
