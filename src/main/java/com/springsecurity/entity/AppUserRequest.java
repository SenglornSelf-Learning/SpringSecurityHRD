package com.springsecurity.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AppUserRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}
