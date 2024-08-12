package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
