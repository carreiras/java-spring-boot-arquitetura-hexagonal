package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "carreiras")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
