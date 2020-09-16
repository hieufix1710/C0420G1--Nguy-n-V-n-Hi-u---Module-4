package com.example.repository;

import com.example.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegisterRepository extends JpaRepository<UserRegister,Long> {
}
