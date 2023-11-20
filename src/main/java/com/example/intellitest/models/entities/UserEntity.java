package com.example.intellitest.models.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserEntity extends BaseEntity {
    @Column(name = "email", nullable = false, unique = true)
    private String email; // –  username of the user.
    
    @Column(nullable = false)
    private String password; //– password of the user.
    
    @Column(nullable = false)
    private String firstName; //–  first name of the user.
    
    @Column(nullable = false)
    private String lastName; //–  last name of the user.
    
    @Column(nullable = false)
    private Boolean IsDeleted;
    
    @Column(nullable = true)
    private String imagePath;
    
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch= FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Role> roles = new ArrayList<>();
    
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//
////        list.add(new SimpleGrantedAuthority(role));
//
//        return list;
//    }
    
    
    public Boolean getDeleted() {
        return IsDeleted;
    }
    
    public void setDeleted(Boolean deleted) {
        IsDeleted = deleted;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getEmail() {
        return email;
    }
    
    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public Boolean isDeleted() {
        return IsDeleted;
    }
    
    public UserEntity setIsDeleted(Boolean deleted) {
        IsDeleted = deleted;
        return this;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
