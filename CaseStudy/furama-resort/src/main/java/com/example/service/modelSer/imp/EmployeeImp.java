package com.example.service.modelSer.imp;


import com.example.entity.model.Employee;
import com.example.repository.modelRepo.EmployeeRepo;
import com.example.service.modelSer.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class    EmployeeImp implements IEmployee {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, String search) {
        String temp="%"+search+"%";
         if ("".equals(search)){
             return employeeRepo.showListEmployee(pageable, search);
         }
         return employeeRepo.showListEmployeeBySearch(pageable,temp);
    }

    @Override
    public void saveEmployee(Employee employee) {
               employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
           employeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }
}
