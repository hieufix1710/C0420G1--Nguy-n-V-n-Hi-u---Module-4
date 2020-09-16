package com.example.validateformsignup.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class User implements Validator {

    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String userName = user.getUserName();
        String password = user.getPassword();
        if (userName.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "userName", "userName.empty");
        }
        if (password.isEmpty()) {
            ValidationUtils.rejectIfEmpty(errors, "password", "password.empty");
        }

        if (password.length() > 6 || password.length() < 8) {
            errors.rejectValue("password", "password.length");
        }


    }
}
