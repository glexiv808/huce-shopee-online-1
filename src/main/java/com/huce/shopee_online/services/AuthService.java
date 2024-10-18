package com.huce.shopee_online.services;

import com.huce.shopee_online.entities.User;
import com.huce.shopee_online.jwt.JWTUtility;
import com.huce.shopee_online.repositories.UserRepository;
import com.huce.shopee_online.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    public String loginWithEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        assert user != null;
        if (PasswordEncoder.getInstance().matches(password, user.getPassword())) {
            return JWTUtility.getInstance().generateTokenWithEmail(email);
        }
        return null;
    }

}
