package com.example.managercustomeruseresful.service;

import java.util.List;

public interface CustomerService <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
    void delete (Long id);
}
