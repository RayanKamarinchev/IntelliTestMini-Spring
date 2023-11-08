package com.example.intellitest.web;

import com.example.intellitest.models.dtos.users.LoginViewModel;
import com.example.intellitest.models.dtos.users.RegisterViewModel;
import com.example.intellitest.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/auth")
public class UserController extends BaseController {
    private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("register")
    public String getRegister(Model model) {
        model.addAttribute("userRegisterForm", new RegisterViewModel());
        return "user/auth-register";
    }
    
    @PostMapping("register")
    public String postRegister(
            @Valid RegisterViewModel userRegisterForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userRegisterForm", userRegisterForm);
            model.addAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);
            return "user/auth-register";
        }
        try{
            userService.registerUser(userRegisterForm);
        }
        catch (IllegalArgumentException e){
            bindingResult.addError(new ObjectError("email","Email already exists"));
            model.addAttribute("userRegisterForm", userRegisterForm);
            model.addAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);
            return "user/auth-register";
        }
        
        return "redirect:/auth/login";
    }
    
    @GetMapping("login")
    private String getLogin(Model model){
        model.addAttribute("userLoginForm", new LoginViewModel());
        return "user/auth-login";
    }
    
    @PostMapping("/login-error")
    public String login(@Valid LoginViewModel userLoginForm, Model model) {
        System.out.println("errorMessage");
        model.addAttribute("userLoginF-orm", userLoginForm);
        model.addAttribute(BINDING_RESULT_PATH + "userLoginForm", userLoginForm);
        return "user/auth-register";
    }
}
