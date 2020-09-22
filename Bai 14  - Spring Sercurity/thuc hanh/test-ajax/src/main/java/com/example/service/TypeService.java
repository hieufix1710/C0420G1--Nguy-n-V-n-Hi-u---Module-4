package com.example.service;

import com.example.model.Type;

import java.util.List;

public interface TypeService {
    List<Type> findAll();
    Type findByName(String name);

}
