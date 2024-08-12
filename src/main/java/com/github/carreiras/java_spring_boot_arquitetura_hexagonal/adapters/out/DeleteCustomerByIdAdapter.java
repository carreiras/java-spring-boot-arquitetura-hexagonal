package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
