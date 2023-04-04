package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {

}
