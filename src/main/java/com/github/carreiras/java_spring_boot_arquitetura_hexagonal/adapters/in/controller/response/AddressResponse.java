package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;
}
