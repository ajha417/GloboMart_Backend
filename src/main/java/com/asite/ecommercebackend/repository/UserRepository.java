package com.asite.ecommercebackend.repository;

import com.asite.ecommercebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}
