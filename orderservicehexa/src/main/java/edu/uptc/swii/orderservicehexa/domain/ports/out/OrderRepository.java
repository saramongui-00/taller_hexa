package edu.uptc.swii.orderservicehexa.domain.ports.out;

import edu.uptc.swii.orderservicehexa.domain.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
}