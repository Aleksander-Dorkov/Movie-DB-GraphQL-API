package com.expence_tracking.app.dto.binding.user.confirm_password_validation;

import com.expence_tracking.app.dto.binding.user.UserCreate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ConfirmPassword implements ConstraintValidator<ValidateConfirmPassword, UserCreate>
{

    @Override
    public void initialize(ValidateConfirmPassword constraintAnnotation)
    {

    }

    @Override
    public boolean isValid(UserCreate user, ConstraintValidatorContext context)
    {
        return user.getPassword().equals(user.getConfirmPassword());
    }

}
