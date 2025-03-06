package com.springsecurity.controller;

import com.springsecurity.entity.ApiResponse;
import com.springsecurity.entity.AppUserDTO;
import com.springsecurity.entity.AppUserRequest;
import com.springsecurity.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/test")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AppUserRequest appUserRequest){
        AppUserDTO appUserDTO = userService.insertUser(appUserRequest);
        ApiResponse<AppUserDTO> response = ApiResponse.<AppUserDTO>builder()
                .message("SUCCESS")
                .status(HttpStatus.OK)
                .payload(appUserDTO)
                .build();
        return ResponseEntity.ok(response);
    }
}
