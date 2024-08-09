package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.client.mapper;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.client.response.AddressResponse;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
