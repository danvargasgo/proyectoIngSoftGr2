package com.unal.cronus.security;

import com.unal.cronus.security.ValidationEmailImp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidationEmailImp.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValitationEmail {
    String message() default " Este email ya se encuentra registrado.";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
