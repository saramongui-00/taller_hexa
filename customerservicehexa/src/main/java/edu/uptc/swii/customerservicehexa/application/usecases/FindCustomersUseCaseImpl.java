package edu.uptc.swii.customerservicehexa.application.usecases;

import java.util.Optional;

import edu.uptc.swii.customerservicehexa.application.ports.in.FindCustomersUseCase;
import edu.uptc.swii.customerservicehexa.application.ports.out.CustomerRepositoryPort;
import edu.uptc.swii.customerservicehexa.domain.model.Customer;
import java.util.List;

public class FindCustomersUseCaseImpl implements FindCustomersUseCase {
    private final CustomerRepositoryPort customerRepositoryPort;

    public FindCustomersUseCaseImpl(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }

    @Override
    public Optional<Customer> getCustomerById(String document) {
        return customerRepositoryPort.findById(document);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepositoryPort.findAll();
    }
}
