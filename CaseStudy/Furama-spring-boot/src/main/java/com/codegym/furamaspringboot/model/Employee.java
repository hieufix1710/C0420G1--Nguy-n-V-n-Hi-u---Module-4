package com.codegym.furamaspringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int idPosition;
    private int idLevel;
    private int idDepartment;
    private String birthday;
    private Long CMND;
    private double salary;
    private String phone;
    private String email;
    private String address;

    public Employee(Long id, String name, int idPosition, int idLevel, int idDepartment, String birthday, Long CMND, double salary, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.idPosition = idPosition;
        this.idLevel = idLevel;
        this.idDepartment = idDepartment;
        this.birthday = birthday;
        this.CMND = CMND;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getCMND() {
        return CMND;
    }

    public void setCMND(Long CMND) {
        this.CMND = CMND;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
