package com.codegym.signupvalidate.model;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table (name = "user")
public class User implements Validator {



    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2,max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 2,max = 45)

    private String lastName;


//    @NotEmpty
//    @Pattern(regexp = "[0]{1}[^0]\\d{8,9}",message = "Phone not null and valid 0xxxxxxxxxx")
    private String phoneNumber;

    @Min(value = 18,message = "age must >=18")
    private int age;

    @Pattern( regexp = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)",message = "Email not valid !")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phone = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phoneNumber", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phoneNumber", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phone.matches");
        }
    }
}
