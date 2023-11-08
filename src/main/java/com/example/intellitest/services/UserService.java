package com.example.intellitest.services;

import com.example.intellitest.models.dtos.users.LoginViewModel;
import com.example.intellitest.models.dtos.users.RegisterViewModel;
import com.example.intellitest.models.entities.UserEntity;
import com.example.intellitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    
    public void registerUser(RegisterViewModel registrationDTO) {
        if (userRepository.getByEmail(registrationDTO.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        UserEntity userEntity = new UserEntity().
                setFirstName(registrationDTO.getFirstName()).
                setLastName(registrationDTO.getLastName()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword()))
                .setIsDeleted(false);
        
        userRepository.save(userEntity);
    }
    
    public UserDetails getUserByEmail(String email) throws UsernameNotFoundException {
        
        Optional<UserEntity> userOpt = userRepository
                .getByEmail(email);
        
        return userOpt.map(this::map).orElse(null);
    }
    
    private User map(UserEntity user) {
        
        List<GrantedAuthority> authorities = user.
                getRoles().
                stream().
                map(r -> new SimpleGrantedAuthority(r.getRole())).
                collect(Collectors.toList());
        
        org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword() != null ? user.getPassword() : "",
                authorities);
        
        if (user.getPassword() == null){
            result.eraseCredentials();
        }
        
        return result;
    }
    
    public void loginUser(LoginViewModel loginViewModel) {
        
        UserDetails user = getUserByEmail(loginViewModel.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        
        Authentication authentication = new
                UsernamePasswordAuthenticationToken(
                user,
                loginViewModel.getPassword(),
                user.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
