package edu.uptc.swii.orderservicehexa.infrastructure.adapters.persistence;

import edu.uptc.swii.orderservicehexa.infrastructure.adapters.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}