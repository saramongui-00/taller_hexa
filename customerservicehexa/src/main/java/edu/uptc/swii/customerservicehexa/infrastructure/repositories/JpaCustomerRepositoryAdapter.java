package edu.uptc.swii.customerservicehexa.infrastructure.repositories;

import edu.uptc.swii.customerservicehexa.application.ports.out.CustomerRepositoryPort;
import edu.uptc.swii.customerservicehexa.infrastructure.entities.CustomerEntity;
import edu.uptc.swii.customerservicehexa.domain.model.Customer;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class JpaCustomerRepositoryAdapter implements CustomerRepositoryPort {
    private final JpaCustomerRepository jpaCustomerRepository;

    public JpaCustomerRepositoryAdapter(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = CustomerEntity.fromDomainModel(customer);
        CustomerEntity savedCustomerEntity = jpaCustomerRepository.save(customerEntity);
        return savedCustomerEntity.toDomainModel();
    }

    @Override
    public Optional<Customer> findById(String document) {
        return jpaCustomerRepository.findById(document)
                .map(CustomerEntity::toDomainModel);
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll().stream()
                .map(CustomerEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> update(Customer customer) {
        if (jpaCustomerRepository.existsById(customer.getDocument())) {
            CustomerEntity customerEntity = CustomerEntity.fromDomainModel(customer);
            CustomerEntity updatedCustomerEntity = jpaCustomerRepository.save(customerEntity);
            return Optional.of(updatedCustomerEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(String document) {
        if (jpaCustomerRepository.existsById(document)) {
            jpaCustomerRepository.deleteById(document);
            return true;
        }
        return false;
    }
}
