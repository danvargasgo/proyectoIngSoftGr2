package com.unal.cronus.security;

import com.unal.cronus.model.entitity.User;
import com.unal.cronus.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidationEmailImp implements ConstraintValidator<ValitationEmail,String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> ouser = userRepository.findById(s);
        return ouser.isEmpty();

    }
}
