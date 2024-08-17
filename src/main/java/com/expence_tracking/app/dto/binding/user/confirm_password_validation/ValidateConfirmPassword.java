package com.expence_tracking.app.dto.binding.user.confirm_password_validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ConfirmPassword.class})
public @interface ValidateConfirmPassword {

    String message() default "password field does not match confirm password field";

    Class<?>[] groups() default {

    };

    Class<? extends Payload>[] payload() default {};
}
