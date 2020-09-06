package com.codegym.signupvalidate.service.imp;

import com.codegym.signupvalidate.model.User;
import com.codegym.signupvalidate.repository.UserRepositoty;
import com.codegym.signupvalidate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

     @Autowired
     private UserRepositoty userRepositoty;
    @Override
    public Page<User> findAll(Pageable pageable, String search) {
        String temp="%"+search+"%";
        if ("".equals(search)){
            return userRepositoty.findAll(pageable,search);
        }
        return userRepositoty.findAllBySearch(pageable, search);
    }

    @Override
    public List<User> findAll() {
        return userRepositoty.findAll();
    }

    @Override
    public void delete(Long id) {
           userRepositoty.deleteById(id);
    }

    @Override
    public boolean save(User user) {
        boolean check=true;
        for (User u : userRepositoty.findAll()) {
            if (user.getPhoneNumber().equals(u.getPhoneNumber()) && user.getEmail().equals(u.getEmail())){
                 check=false;
            }
        }
        userRepositoty.saveAndFlush(user);
        return check;

    }
}
