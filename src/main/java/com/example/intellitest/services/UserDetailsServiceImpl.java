package com.example.intellitest.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.intellitest.models.dtos.users.CustomUser;
import com.example.intellitest.models.entities.UserEntity;
import com.example.intellitest.repositories.StudentRepository;
import com.example.intellitest.repositories.TeacherRepository;
import com.example.intellitest.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.intellitest.models.entities.Student;
import com.example.intellitest.models.entities.Teacher;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    
    public UserDetailsServiceImpl(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity domainUser = userRepository.getByEmail(username).get();
        
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Long studentId = studentRepository.getByUserId(domainUser.getId()).map(Student::getId).orElse(null);
        Long teacherId = teacherRepository.getByUserId(domainUser.getId()).map(Teacher::getId).orElse(null);
        return new CustomUser(
                domainUser.getEmail(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                domainUser.
                        getRoles().
                        stream().
                        map(r -> new SimpleGrantedAuthority(r.getRole())).
                        collect(Collectors.toList()),
                domainUser.getId(),
                studentId,
                teacherId
                );
            
//        return userOpt.map(this::map).orElseThrow(
//                () -> new UsernameNotFoundException("No user " + username));
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
