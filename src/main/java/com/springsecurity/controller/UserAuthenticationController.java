package com.springsecurity.controller;

import com.springsecurity.model.ApiResponse;
import com.springsecurity.model.AppUserDTO;
import com.springsecurity.model.AppUserRequest;
import com.springsecurity.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAuthenticationController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String sayHello() {
        return "Welcome to Spring Security";
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<AppUserDTO>> create(@RequestBody AppUserRequest appUserRequest) {
        AppUserDTO appUserDTO = userService.insertUser(appUserRequest);

        ApiResponse<AppUserDTO> response = ApiResponse.<AppUserDTO>builder()
                .message("SUCCESS")
                .status(HttpStatus.OK)
                .payload(appUserDTO)
                .build();
        return ResponseEntity.ok(response);
    }
}
