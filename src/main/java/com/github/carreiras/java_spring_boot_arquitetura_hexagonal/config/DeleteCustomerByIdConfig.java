package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.config;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
