package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehicleRepo extends MongoRepository<Vehicle,String> {
    List<Vehicle> findByUserEmail(String userEmail);
}
