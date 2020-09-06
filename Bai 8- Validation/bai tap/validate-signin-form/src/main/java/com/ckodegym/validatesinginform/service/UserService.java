package com.ckodegym.validatesinginform.service;

import com.ckodegym.validatesinginform.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface  UserService {
    List<User> findAll();
    void update(Long id, User User);
    void delete(Long id);
    void save(User customer);
    User findById(Long id);
    Page<User> findAll(Pageable pageable);
}
