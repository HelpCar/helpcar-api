package com.thefiveofus.helpcarapi.controller;

import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.model.Vehicle;
import com.thefiveofus.helpcarapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public String updateSingleUser(@PathVariable String email,@RequestBody User user ){
        userService.updateSingleUser(email,user);
        return "User updated Successfully!";
    }

    @GetMapping("/get_vehicles/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Vehicle> getVehiclesByUserId(@PathVariable String id){
        return userService.getVehiclesOfUser(id);
    }

}
