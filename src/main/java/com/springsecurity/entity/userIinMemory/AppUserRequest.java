package com.springsecurity.entity.userIinMemory;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AppUserRequest {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
}
