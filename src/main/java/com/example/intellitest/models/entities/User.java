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
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Boolean getActive() {
        return isActive;
    }
    
    public void setActive(Boolean active) {
        isActive = active;
    }
}
