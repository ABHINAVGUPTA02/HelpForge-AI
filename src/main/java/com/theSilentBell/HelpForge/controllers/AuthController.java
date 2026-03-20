package com.theSilentBell.HelpForge.controllers;

import com.theSilentBell.HelpForge.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theSilentBell.HelpForge.models.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(
            value = "/signup",
            consumes = "application/json"
    )
    @Operation(summary = "creates a new user")
    public ResponseEntity<String> signUp(@RequestBody User user) throws Exception {
        if(!authService.userSignUp(user)) {
            return ResponseEntity
                    .status(409)
                    .body("user already exists");
        }
        return ResponseEntity
                .status(201)
                .body("user created successfully");
    }

    @PostMapping(
            value = "/login",
            consumes = "application/json"
    )
    @Operation(summary = "authenticates and login the user")
    public ResponseEntity<String> login(@RequestBody User user) throws Exception {
        if(!authService.UserLogin(user)) {
            return ResponseEntity
                    .status(409)
                    .body("invalid username or password");
        }

        return ResponseEntity
                .status(200)
                .body("logged in successfully");
    }
}
