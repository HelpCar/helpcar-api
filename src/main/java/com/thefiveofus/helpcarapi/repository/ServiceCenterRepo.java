package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.ServiceCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceCenterRepo extends MongoRepository<ServiceCenter, String> {

}
