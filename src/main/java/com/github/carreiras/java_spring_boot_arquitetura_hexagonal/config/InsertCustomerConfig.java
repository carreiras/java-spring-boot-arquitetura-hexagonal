package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.config;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.InsertCustomerAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
