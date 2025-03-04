package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String hello(){
        return "Hello welcome to Spring Security, admin and user role can access";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin Page, Only admin can access";
    }

    @GetMapping("/user")
    public String user(){
        return "User Page, Only user can access";
    }

    @GetMapping("/all")
    public String all(){
        return "All user can access Class";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye Bye Class";
    }
}
