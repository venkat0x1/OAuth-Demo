package com.oauth.demo.controllers;


import com.oauth.demo.entities.User;
import com.oauth.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String welcomeToHome(){
        return "Hi welcome to the multiverse..!";
    }

    @Autowired
    private UserRepository userRepository;

    // Existing code for login, home, and user pages

    @GetMapping("/register")
    public String register(@AuthenticationPrincipal OAuth2User principal, Model model) {

//        model.

        if (principal != null) {
            System.out.println("==============================================================");

            String username = principal.getAttribute("login");
//            System.out.println(principal.getAttribute("email"));
            User existingUser = userRepository.findByEmail(username);
            if (existingUser == null) {
                User newUser = new User();
                newUser.setEmail(username);
//                newUser.setEnabled(true);
                userRepository.save(newUser);

                System.out.println("==============================================================");
            }
        }
        return "redirect";
    }

    @GetMapping("/user-attributes")
    public Map<String, Object> getUserAttributes(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            return principal.getAttributes();
//             attributes;
        }
        return null; // or an empty map, depending on your desired behavior
    }

}
