package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
