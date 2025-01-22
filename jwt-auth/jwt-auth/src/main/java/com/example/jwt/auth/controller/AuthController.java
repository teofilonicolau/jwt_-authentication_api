
package com.example.jwt.auth.controller;

import com.example.jwt.auth.model.User;
import com.example.jwt.auth.repository.UserRepository;
import com.example.jwt.auth.service.UserService;
import com.example.jwt.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.saveUser(user);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try {
            System.out.println("Iniciando autenticação para " + user.getUsername());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            System.out.println("Autenticação bem sucedida para " + user.getUsername());
            String token = jwtUtil.generateToken(authentication.getName());
            System.out.println("Token gerado: " + token);
            return ResponseEntity.ok(token);
        } catch (ClassCastException e) {
            System.out.println("Erro na autenticação: conversão de classe" + e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Problema de conversão na autenticação");
        } catch (AuthenticationException ex) {
            System.out.println("Erro na autenticação " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Credenciais inválidas ou problema na autenticação");
        }
    }



}
