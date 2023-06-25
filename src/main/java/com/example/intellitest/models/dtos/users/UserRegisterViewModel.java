package com.example.intellitest.models.dtos.users;

import com.example.intellitest.validations.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class UserRegisterViewModel {
    @NotBlank
    @Email
    private String email;
    
    @NotNull
    @Size(min = 5, max = 20)
    private String password;
    
    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;
    
    @NotNull
    @Size(min = 5, max = 20)
    private String firstName;
    
    @NotNull
    @Size(min = 5, max = 20)
    private String lastName;
    
    public String getEmail() {
        return email;
    }
    
    public UserRegisterViewModel setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public String getPassword() {
        return password;
    }
    
    public UserRegisterViewModel setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
    public UserRegisterViewModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public UserRegisterViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public UserRegisterViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
