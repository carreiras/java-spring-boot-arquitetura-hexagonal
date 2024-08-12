package com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.core.usecase;

import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.github.carreiras.java_spring_boot_arquitetura_hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);

    }
}
