package com.codegym.furamaspringboot.repository;

import com.codegym.furamaspringboot.model.Customer;
import com.codegym.furamaspringboot.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Long> {


    @Query("select c from Employee  c where c.name like :name")
    Page<Employee> showListEmployeeBySearch(Pageable page, String name);

    @Query ("select c from Customer  c")
    Page<Employee> showListEmployee(Pageable page, String name);
}
