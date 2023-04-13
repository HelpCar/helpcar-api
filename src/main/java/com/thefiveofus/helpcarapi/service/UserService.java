package com.thefiveofus.helpcarapi.service;

import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.model.Vehicle;
import com.thefiveofus.helpcarapi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepo userRepo;

    public void registerUser(User user){
        user = User.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .imgUrl(user.getImgUrl())
                .coins(user.getCoins())
                .build();

        userRepo.save(user);
        log.info("User {} is saved", user.getId());

    }

    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    public void updateSingleUser(String email, User user) {
        List<User> users=getAllUsers();
        User updatedUser = null;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(email)) {
               updatedUser=users.get(i);
            }
        }
        if(updatedUser!=null){
            updatedUser.setFullName(user.getFullName());
            updatedUser.setImgUrl(user.getImgUrl());
            userRepo.save(updatedUser);
        }

    }
}
