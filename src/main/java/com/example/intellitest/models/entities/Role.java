package com.example.intellitest.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    
    @Column(name = "role", nullable = false)
    private String role;
    
    public Role setId(long id) {
        this.id = id;
        return this;
    }
    
    public Role setRole(String role) {
        this.role = role;
        return this;
    }
    
    public long getId() {
        return id;
    }
    
    public String getRole() {
        return role;
    }
}
