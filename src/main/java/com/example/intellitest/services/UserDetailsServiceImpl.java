package com.example.intellitest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.intellitest.models.entities.UserEntity;
import com.example.intellitest.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    private final UserRepository userRepository;
    
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UserEntity> userOpt = userRepository
                .getByEmail(username);
        
        LOGGER.debug("Trying to load user {}. Success = {}.", username, userOpt.isPresent());
        
        return userOpt.map(this::map).orElseThrow(
                () -> new UsernameNotFoundException("No user " + username));
    }
    
    private User map(UserEntity user) {
        
        List<GrantedAuthority> authorities = user.
                getRoles().
                stream().
                map(r -> new SimpleGrantedAuthority(r.getRole())).
                collect(Collectors.toList());
        
        User result = new User(user.getEmail(),
                user.getPassword() != null ? user.getPassword() : "",
                authorities);
        
        if (user.getPassword() == null){
            result.eraseCredentials();
        }
        
        return result;
    }
}
