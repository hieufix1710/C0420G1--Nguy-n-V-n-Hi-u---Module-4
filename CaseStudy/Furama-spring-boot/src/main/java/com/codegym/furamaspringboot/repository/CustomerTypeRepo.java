package com.codegym.furamaspringboot.repository;

import com.codegym.furamaspringboot.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepo extends JpaRepository<CustomerType,Long> {
}
