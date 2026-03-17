package com.theSilentBell.HelpForge.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theSilentBell.HelpForge.models.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping(
            value = "/signup",
            consumes = "application/json"
    )
    @Operation(summary = "creates a new user")
    public String signUp(@RequestBody User user) throws Exception {
        try {
            return user.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping(
            value = "/login",
            consumes = "application/json"
    )
    @Operation(summary = "authenticates and login the user")
    public String login(@RequestBody User user) throws Exception {
        try {
            return user.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
