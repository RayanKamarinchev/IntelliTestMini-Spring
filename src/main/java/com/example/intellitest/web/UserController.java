package com.example.intellitest.web;

import com.example.intellitest.mappers.UserMapper;
import com.example.intellitest.models.dtos.users.*;
import com.example.intellitest.models.entities.UserEntity;
import com.example.intellitest.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.io.IOException;

@Controller
public class UserController extends BaseController {
    private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("auth/register")
    public String getRegister(Model model) {
        model.addAttribute("userRegisterForm", new RegisterViewModel());
        return "user/auth-register";
    }
    
    @PostMapping("auth/register")
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
    
    @GetMapping("auth/login")
    private String getLogin(Model model){
        model.addAttribute("userLoginForm", new LoginViewModel());
        return "user/auth-login";
    }
    
    @PostMapping("auth/login-error")
    public String login(@Valid LoginViewModel userLoginForm, Model model) {
        System.out.println("errorMessage");
        model.addAttribute("userLoginF-orm", userLoginForm);
        model.addAttribute(BINDING_RESULT_PATH + "userLoginForm", userLoginForm);
        return "user/auth-register";
    }
    
    @GetMapping("profile")
    public String getProfile(Model model, HttpSession session){
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EditUser dto = userService.getEditUserById(user.getId());
        if(dto == null){
            return "redirect:/logout";
        }
        boolean isTeacher = user.getTeacherId() != null;
        boolean isStudent = user.getStudentId() != null;
        dto.setIsTeacher(isTeacher);
        dto.setIsTeacher(isStudent);
        if (dto.getImagePath() == null || dto.getImagePath() == ""){
            dto.setImagePath("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png");
        }
        else{
            dto.setImagePath("img/" + dto.getImagePath());
        }
        model.addAttribute("formData", dto);
        model.addAttribute("id", user.getId());
        session.setAttribute("imageUrl", dto.getImagePath());
        return "user/profile";
    }
    
    //get Image form file (binary) from form data
    @PostMapping("profile")
    public String postProfile(@Valid @ModelAttribute("formData") EditUser editUser,
                              BindingResult bindingResult,
                              Model model,
                              HttpSession session,
                              HttpServletRequest request) throws IOException {
        //TODO: error when remember me is not checked
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = user.getId();
        editUser.setUserId(id);
        editUser.setImageFolderPath(request.getServletContext().getRealPath("/"));
        if (bindingResult.hasErrors()) {
            if (editUser.getImage() != null) {
                userService.updateUser(editUser, false, false);
            }
            else {
                if (editUser.getImagePath() == null || editUser.getImagePath() == ""){
                    editUser.setImagePath("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png");
                }
                model.addAttribute("formData", editUser);
                model.addAttribute(BINDING_RESULT_PATH + "formData", bindingResult);
            }
            return "redirect:/profile";
        }
        editUser.setImagePath((String)session.getAttribute("imageUrl"));
        try{
            RoleInfo roleInfo = userService.updateUser(editUser, user.getStudentId() != null,
                    user.getTeacherId() != null);
            
            if (roleInfo != null) {
                if (roleInfo.getRole() == "Student") {
                    user.setStudentId(roleInfo.getId());
                } else {
                    user.setTeacherId(roleInfo.getId());
                }
            }
        }
        catch (IllegalArgumentException e){
            bindingResult.addError(new ObjectError("email","Email already exists"));
            model.addAttribute("formData", editUser);
            model.addAttribute(BINDING_RESULT_PATH + "formData", bindingResult);
            return "user/profile";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/profile";
    }
}
