package com.delivery.authenticationservice.service;

import com.delivery.authenticationservice.domain.Users;
import com.delivery.authenticationservice.repo.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public Users saveUsers(Users users){
        users.setUniqueUserId(UUID.randomUUID().toString());
        return authRepository.save(users);
    }

    public Users fetchUserByEmailId(String email){
        return authRepository.findByEmailId(email);
    }

    public Users fetchUserByEmailIdAndPassword(String email, String password){
        return authRepository.findByEmailIdAndPassword(email, password);
    }
}
