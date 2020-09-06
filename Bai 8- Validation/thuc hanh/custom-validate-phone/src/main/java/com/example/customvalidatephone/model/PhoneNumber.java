package com.example.customvalidatephone.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneNumber implements Validator {
    private String phoneNumber;


    @NotEmpty
    @Size (min = 10,message = "phone number must start wit 10 and 11")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
             PhoneNumber phoneNumber=(PhoneNumber) target;
             String phone=phoneNumber.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phone","phone.empty");
        if (phone.length()>11||phone.length()<10){
            errors.rejectValue("phone","phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
    }
}
