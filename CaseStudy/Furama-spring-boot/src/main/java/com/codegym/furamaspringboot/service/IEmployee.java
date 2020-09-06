package com.codegym.furamaspringboot.service;

import com.codegym.furamaspringboot.model.Employee;
import com.codegym.furamaspringboot.model.TypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployee {

    Page<Employee> findAllEmployee(Pageable pageable, String search);
    void saveEmployee(Employee employee);
    void deleteEmployee(Long id);

    Employee findById(Long id);

    List<Employee> findAllEmployee ();
}
