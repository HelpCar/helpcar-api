package com.thefiveofus.helpcarapi.service;

import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepo userRepo;

    public void registerUser(User user){
        user = User.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();

        userRepo.save(user);
        log.info("User {} is saved", user.getId());

    }

    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }
}
