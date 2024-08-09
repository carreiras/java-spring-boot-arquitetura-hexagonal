package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
