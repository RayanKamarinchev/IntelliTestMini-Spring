package com.example.intellitest.models.dtos.users;

public class RoleInfo {
    private String role;
    private Long id;
    
    public RoleInfo() {
    }
    
    public RoleInfo(String role, Long id) {
        this.role = role;
        this.id = id;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
