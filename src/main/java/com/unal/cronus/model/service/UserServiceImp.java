package com.unal.cronus.model.service;

import com.unal.cronus.model.entitity.User;
import com.unal.cronus.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    protected UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional()
    public User save(User entity) {
        //entity.setTypeUser(TypeUser.STUDENT);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    @Transactional()
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
 }

