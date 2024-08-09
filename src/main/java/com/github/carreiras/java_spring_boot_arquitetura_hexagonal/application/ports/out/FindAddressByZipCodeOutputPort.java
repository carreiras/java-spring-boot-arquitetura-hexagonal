package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
