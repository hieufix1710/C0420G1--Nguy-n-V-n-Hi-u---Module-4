package com.codegym.furamaspringboot.service.imp;

import com.codegym.furamaspringboot.model.User;
import com.codegym.furamaspringboot.repository.UserRepo;
import com.codegym.furamaspringboot.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImp implements IUser {

    @Autowired
     private UserRepo userRepo;
    @Override
    public Page<User> findAllUser(Pageable pageable, String search) {
        return null;
    }

    @Override
    public void saveUser(User user) {
            userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
              userRepo.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public boolean check(User user) {
        for (User user1 : userRepo.findAll()) {
            System.out.println(user1.toString());
            if (user.getUserName().equals(user1.getUserName())&& user.getPassword().equals(user1.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
