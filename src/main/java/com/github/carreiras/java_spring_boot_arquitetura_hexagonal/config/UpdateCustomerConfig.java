package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.config;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.UpdateCustomerAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
