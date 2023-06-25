package com.example.intellitest.services;

import com.example.intellitest.models.dtos.users.UserRegisterViewModel;
import com.example.intellitest.models.entities.User;
import com.example.intellitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    
    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public void registerUser(UserRegisterViewModel registrationDTO) {
        
        User userEntity = new User().
                setFirstName(registrationDTO.getFirstName()).
                setLastName(registrationDTO.getLastName()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        
        userRepository.save(userEntity);
    }
}
