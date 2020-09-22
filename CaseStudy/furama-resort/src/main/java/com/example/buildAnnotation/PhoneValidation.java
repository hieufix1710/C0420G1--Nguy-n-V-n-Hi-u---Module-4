package com.example.buildAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidation implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.length()<10 || value.length()>11){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("length form 10 to 11.").addConstraintViolation();
            return false;
        }
        if (!value.startsWith("09")){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("start width 09.").addConstraintViolation();
            return false;
        }
        return false;
    }
}
