package com.codegym.signupvalidate.service;

import com.codegym.signupvalidate.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<User> findAll(Pageable pageable,String search);
    List<User> findAll();
    void delete(Long id);
    boolean save(User user);
}
