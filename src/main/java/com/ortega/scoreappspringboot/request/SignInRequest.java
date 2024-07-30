package com.ortega.scoreappspringboot.request;

import com.ortega.scoreappspringboot.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
    private String email;
    private String password;
}
