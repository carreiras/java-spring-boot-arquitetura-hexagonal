package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
