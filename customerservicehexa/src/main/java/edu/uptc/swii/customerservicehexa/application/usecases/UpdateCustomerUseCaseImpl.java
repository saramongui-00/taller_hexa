package edu.uptc.swii.customerservicehexa.application.usecases;

import edu.uptc.swii.customerservicehexa.application.ports.out.CustomerRepositoryPort;
import edu.uptc.swii.customerservicehexa.application.ports.in.UpdateCustomerUseCase;
import edu.uptc.swii.customerservicehexa.domain.model.Customer;
import java.util.Optional;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {
    private final CustomerRepositoryPort customerRepositoryPort;

    public UpdateCustomerUseCaseImpl(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public Optional<Customer> updateCustomer(String document, Customer updateCustomer) {
        return customerRepositoryPort.update(updateCustomer);
    }

}
