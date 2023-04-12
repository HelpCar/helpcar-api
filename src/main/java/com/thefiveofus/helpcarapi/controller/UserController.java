package com.thefiveofus.helpcarapi.controller;

import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "User Registered Successfully!";
    }

}
