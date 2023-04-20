package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepo extends MongoRepository<Admin, String> {

}
