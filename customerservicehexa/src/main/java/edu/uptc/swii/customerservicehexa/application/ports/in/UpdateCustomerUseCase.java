package edu.uptc.swii.customerservicehexa.application.ports.in;

import edu.uptc.swii.customerservicehexa.domain.model.Customer;
import java.util.Optional;

public interface UpdateCustomerUseCase {
    Optional<Customer> updateCustomer(String document, Customer updateCustomer);
}
