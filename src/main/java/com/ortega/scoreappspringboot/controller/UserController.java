package com.ortega.scoreappspringboot.controller;

import com.ortega.scoreappspringboot.model.User;
import com.ortega.scoreappspringboot.request.SignInRequest;
import com.ortega.scoreappspringboot.request.SignUpRequest;
import com.ortega.scoreappspringboot.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getPassword());
    }

    @PostMapping("/signin")
    public User signIn(@RequestBody SignInRequest signInRequest) {
        return userService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
    }

    @DeleteMapping
    public void deleteUser(@PathParam("id") String id) {
        userService.deleteUser(id);
    }
}
