package com.unal.cronus.model.repository;

import com.unal.cronus.model.entitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
