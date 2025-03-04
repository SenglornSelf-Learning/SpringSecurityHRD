package com.springsecurity.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AppUserDTO {
    private Integer id;
    private String name;
    private String email;
    private String role;
}
