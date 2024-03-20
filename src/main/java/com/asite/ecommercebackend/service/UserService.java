package com.asite.ecommercebackend.service;

import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface UserService {
    public User findUserById(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;

}
