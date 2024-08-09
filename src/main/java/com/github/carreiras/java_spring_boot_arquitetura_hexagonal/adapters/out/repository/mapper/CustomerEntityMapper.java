package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.mapper;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
