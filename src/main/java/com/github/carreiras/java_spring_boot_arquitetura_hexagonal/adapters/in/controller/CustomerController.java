package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller.request.CustomerRequest;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller.response.CustomerResponse;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
