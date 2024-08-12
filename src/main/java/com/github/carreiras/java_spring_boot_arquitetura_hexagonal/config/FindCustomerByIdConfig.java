package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.config;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
