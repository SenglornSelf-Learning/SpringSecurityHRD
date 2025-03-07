package com.springsecurity.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApiResponse<T> {
    private String message;
    private HttpStatus status;
    private T payload;
}
