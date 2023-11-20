package com.example.intellitest.web;

import com.example.intellitest.models.dtos.users.CustomUser;
import com.example.intellitest.services.TestService;
import com.example.intellitest.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/tests")
public class TestController extends BaseController {
    private final TestService testService;
    private final UserService userService;
    
    public TestController(TestService testService, UserService userService) {
        this.testService = testService;
        this.userService = userService;
    }
    
    @GetMapping("all")
//    @PreAuthorize("hasRole('Student')")
    public String getAllTests(Model model) {
        CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var tests = testService.getAllTests(user.getTeacherId(), user.getStudentId());
        model.addAttribute("formData", tests);
        model.addAttribute("isTeacher", user.getTeacherId() != null);
        model.addAttribute("paginationStart", 1);
        model.addAttribute("paginationEnd", 1);
        model.addAttribute("maxPage", 1);
        return "tests/index";
    }
}
