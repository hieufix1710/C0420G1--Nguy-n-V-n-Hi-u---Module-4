package com.codegym.provindecustomer.repository;

import com.codegym.provindecustomer.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends JpaRepository<Province,Long> {
}
