package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepo extends MongoRepository<Vehicle,String> {
}
