package com.example.intellitest.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String email; // –  username of the user.
    
    @Column(nullable = false)
    private String password; //– password of the user.
    
    @Column(nullable = false)
    private String firstName; //–  first name of the user.
    
    @Column(nullable = false)
    private String lastName; //–  last name of the user.
    
    @Column(nullable = false)
    private Boolean isActive; //– true OR false.
    
    public String getEmail() {
        return email;
    }
    
    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public Boolean getActive() {
        return isActive;
    }
    
    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }
}
