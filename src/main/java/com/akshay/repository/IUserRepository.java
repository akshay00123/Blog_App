package com.akshay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akshay.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
