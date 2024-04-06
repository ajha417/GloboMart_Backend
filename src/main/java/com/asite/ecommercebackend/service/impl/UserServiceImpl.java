package com.asite.ecommercebackend.service.impl;

import com.asite.ecommercebackend.config.JwtProvider;
import com.asite.ecommercebackend.exception.UserException;
import com.asite.ecommercebackend.model.User;
import com.asite.ecommercebackend.repository.UserRepository;
import com.asite.ecommercebackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;

    /**
    * This method will find User by its id
    * @param userId
     * @return User
     * @throws UserException
    * */
    @Override
    public User findUserById(Long userId) throws UserException {
        log.debug("UserServiceImpl.findUserById()-->Enter");
        long startTime = System.currentTimeMillis();
        try{
            Optional<User> user = userRepository.findById(userId);
            if (user.isPresent()) {
                return user.get();
            }
        }
        catch (Exception e) {
            log.debug("Error is :",e);
            throw new UserException("User not found with id:"+userId);
        }
        if(log.isDebugEnabled()){
            log.debug("UserServiceImpl.findUserById()-->Exit and completed in -->{}",System.currentTimeMillis()-startTime);
        }
        return null;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        try{
            String email = jwtProvider.getEmailFromToken(jwt);
            User user = userRepository.findByEmail(email);
            if (user == null) {
                throw new UserException("User not found with email:"+email);
            }
            return user;
        }
        catch (Exception e){
            log.debug("Error is :",e);
            throw new UserException("User not found");
        }
    }
}
