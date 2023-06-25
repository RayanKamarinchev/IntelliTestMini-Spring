package com.example.intellitest.web;

import com.example.intellitest.models.dtos.users.UserRegisterViewModel;
import com.example.intellitest.services.UserService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class UserController {
    private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/register")
    public String getRegister() {
        return "auth-register";
    }
    
    @PostMapping("/register")
    public String postRegister(
            @Valid UserRegisterViewModel userRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterForm", userRegisterForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);
            
            return "redirect:/users/register";
        }
        
        userService.registerUser(userRegisterForm);
        
        return "redirect:/users/login";
    }
    
    @ModelAttribute(name = "userRegisterForm")
    public UserRegisterViewModel initUserRegisterFormDto() {
        return new UserRegisterViewModel();
    }
    
    @GetMapping("/login")
    private String getLogin(){
        return "auth-login";
    }
    
    @PostMapping("/users/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
            RedirectAttributes redirectAttributes) {
        
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("bad_credentials", true);
        
        return "redirect:/users/login";
    }
}
