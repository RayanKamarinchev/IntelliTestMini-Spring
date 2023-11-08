package com.example.intellitest.models.dtos.users;

import jakarta.validation.constraints.NotNull;

public class LoginViewModel {
    //TODO external login
    @NotNull
    private String username;
    
    @NotNull
    private String password;
    
//    private boolean rememberMe;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String email) {
        this.username = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
//    public boolean isRememberMe() {
//        return rememberMe;
//    }
    
//    public void setRememberMe(boolean rememberMe) {
//        this.rememberMe = rememberMe;
//    }
}
