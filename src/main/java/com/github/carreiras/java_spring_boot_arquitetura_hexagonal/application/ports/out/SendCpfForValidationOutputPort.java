package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);
}
