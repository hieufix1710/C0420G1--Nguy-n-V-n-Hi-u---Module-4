package com.ckodegym.validatesinginform.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size (min = 5,max = 45)
    private String firstName;
    @NotEmpty
    @Size (min = 5,max = 45)
    private String lastName;


    @Pattern(regexp = "^0[^0]\\d{8,9}$",message = "Number phone must start with 0 and lenght 10 to 11 number")
    private String phoneNumber;


    @Min(18)
    @Max(50)
    private int age;

    @NotEmpty
    @Pattern(regexp = "^\\d{2}[./-]\\d{2}[./-]\\d{4}$",message = "birthday like 01-01-1950")
    private String birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
