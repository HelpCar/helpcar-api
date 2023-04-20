package com.thefiveofus.helpcarapi.controller;

import com.thefiveofus.helpcarapi.model.Admin;
import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registerAdmin(@RequestBody Admin admin){
        adminService.registerAdmin(admin);
        return "Admin Registered Successfully!";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }



}
