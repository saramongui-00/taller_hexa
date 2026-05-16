package edu.uptc.swii.customerservicehexa.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.uptc.swii.customerservicehexa.infrastructure.entities.CustomerEntity;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, String> {

}
