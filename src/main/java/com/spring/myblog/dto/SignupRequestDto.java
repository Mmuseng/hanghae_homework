package com.spring.myblog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
}