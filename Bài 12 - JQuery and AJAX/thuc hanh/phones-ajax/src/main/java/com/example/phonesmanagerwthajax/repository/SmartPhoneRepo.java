package com.example.phonesmanagerwthajax.repository;

import com.example.phonesmanagerwthajax.model.SmartPhones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartPhoneRepo extends JpaRepository <SmartPhones,Long > {
}
