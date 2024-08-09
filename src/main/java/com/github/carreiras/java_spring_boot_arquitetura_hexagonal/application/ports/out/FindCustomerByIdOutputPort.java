package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
