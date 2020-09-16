package com.example.repository.modelRepo;


import com.example.entity.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepo extends JpaRepository<CustomerType,Long> {
}
