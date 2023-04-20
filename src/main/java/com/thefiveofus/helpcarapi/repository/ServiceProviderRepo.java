package com.thefiveofus.helpcarapi.repository;

import com.thefiveofus.helpcarapi.model.ServiceProvider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceProviderRepo extends MongoRepository<String, ServiceProvider> {
}
