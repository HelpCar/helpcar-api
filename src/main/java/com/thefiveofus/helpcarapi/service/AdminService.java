package com.thefiveofus.helpcarapi.service;

import com.thefiveofus.helpcarapi.model.Admin;
import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepo adminRepo;

    public void registerAdmin(Admin admin){
        admin = Admin.builder()
                .adminName(admin.getAdminName())
                .email(admin.getEmail())
                .build();

        adminRepo.save(admin);
        log.info("Admin {} is saved", admin.getId());

    }

    public List<Admin> getAllAdmins() {
        List<Admin> admins = adminRepo.findAll();
        return admins;
    }

}
