package edu.uptc.swii.customerservicehexa.application.services;

import edu.uptc.swii.customerservicehexa.application.ports.in.CreateCustomerUseCase;
import edu.uptc.swii.customerservicehexa.application.ports.in.DeleteCustomerUseCase;
import edu.uptc.swii.customerservicehexa.application.ports.in.FindCustomersUseCase;
import edu.uptc.swii.customerservicehexa.application.ports.in.UpdateCustomerUseCase;

import java.util.Optional;
import java.util.List;
import edu.uptc.swii.customerservicehexa.domain.model.Customer;

public class CustomerService
        implements CreateCustomerUseCase, DeleteCustomerUseCase, FindCustomersUseCase, UpdateCustomerUseCase {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final FindCustomersUseCase findCustomersUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerService(CreateCustomerUseCase createCustomerUseCase, DeleteCustomerUseCase deleteCustomerUseCase,
            FindCustomersUseCase findCustomersUseCase, UpdateCustomerUseCase updateCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.findCustomersUseCase = findCustomersUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @Override
    public Optional<Customer> updateCustomer(String document, Customer updatedCustomer) {
        return updateCustomerUseCase.updateCustomer(document, updatedCustomer);
    }

    @Override
    public Optional<Customer> getCustomerById(String document) {
        return findCustomersUseCase.getCustomerById(document);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return findCustomersUseCase.findAllCustomers();
    }

    @Override
    public boolean deleteCustomer(String document) {
        return deleteCustomerUseCase.deleteCustomer(document);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return createCustomerUseCase.createCustomer(customer);
    }
}
