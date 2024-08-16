package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ReceiveValidatedCpfConsumer.class);

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "carreiras")
    public void receive(CustomerMessage customerMessage) {
        logger.info("Received message: {}", customerMessage);
        var customer = customerMessageMapper.toCustomer(customerMessage);
        logger.info("Mapped customer: {}", customer);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
