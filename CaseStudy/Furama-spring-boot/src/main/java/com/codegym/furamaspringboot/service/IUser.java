package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.TypeService;
import com.codegym.furamaspringboot.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUser {

    Page<User> findAllUser(Pageable pageable, String search);
    void saveUser(User user);
    void deleteUser(Long id);

    User findById(Long id);

    List<User> findAllUser ();

    boolean check (User user);
}
