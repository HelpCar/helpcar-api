package com.thefiveofus.helpcarapi.service;

import com.thefiveofus.helpcarapi.model.User;
import com.thefiveofus.helpcarapi.model.Vehicle;
import com.thefiveofus.helpcarapi.repository.UserRepo;
import com.thefiveofus.helpcarapi.repository.VehicleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepo userRepo;
    private final VehicleRepo vehicleRepo;

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

    public List<Vehicle> getVehiclesOfUser(String userId){

        List<Vehicle> vehicles = vehicleRepo.findByUserEmail(getUserEmailById(userId));
        return vehicles;

    }

    public String getUserEmailById(String userId){
        Optional<User> user;
        user = userRepo.findById(userId);

        String email;
        email=user.get().getEmail();

        return email;
    }
}
