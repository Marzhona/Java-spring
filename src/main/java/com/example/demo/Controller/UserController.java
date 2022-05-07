package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("userForm", new User());

        return "registration";

    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm) {

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(Model model) {

        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        return "login";
    }
}