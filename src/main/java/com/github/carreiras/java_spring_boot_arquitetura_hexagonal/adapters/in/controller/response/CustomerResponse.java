package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isvalidCpf;
}
