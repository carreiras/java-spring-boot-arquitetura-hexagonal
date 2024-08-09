package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.CustomerRepository;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
