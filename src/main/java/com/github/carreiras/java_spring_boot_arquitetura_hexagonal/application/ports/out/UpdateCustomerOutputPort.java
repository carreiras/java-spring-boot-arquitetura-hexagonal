package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
