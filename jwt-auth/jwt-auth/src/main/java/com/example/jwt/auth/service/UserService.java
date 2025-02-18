package com.example.jwt.auth.service;

import com.example.jwt.auth.model.User;
import com.example.jwt.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        // criptografar a senha
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        // encontrar usuário pelo nome de usuário
        return userRepository.findByUsername(username).orElse(null);
    }
}
