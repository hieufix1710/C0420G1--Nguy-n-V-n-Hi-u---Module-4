package com.ckodegym.validatesinginform.repository;

import com.ckodegym.validatesinginform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
