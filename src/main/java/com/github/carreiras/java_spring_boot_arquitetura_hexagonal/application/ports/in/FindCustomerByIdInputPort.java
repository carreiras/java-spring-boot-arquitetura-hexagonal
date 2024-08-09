package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
