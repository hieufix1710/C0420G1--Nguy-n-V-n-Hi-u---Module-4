package com.codegym.signupvalidate.repository;

import com.codegym.signupvalidate.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoty extends JpaRepository<User,Long> {
    @Query ("select c from User  c where  c.firstName like ?2")
    Page<User> findAllBySearch(Pageable pageable, String search);

    @Query ("select c from User  c")
    Page<User> findAll(Pageable pageable, String search);

}
