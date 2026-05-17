package edu.uptc.swii.orderservicehexa.infrastructure.adapters.persistence;

import edu.uptc.swii.orderservicehexa.domain.model.Order;
import edu.uptc.swii.orderservicehexa.domain.ports.out.OrderRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository jpaRepository;

    public OrderRepositoryImpl(OrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setProductName(order.getProductName());
        entity.setQuantity(order.getQuantity());
        entity.setCustomerName(order.getCustomerName());
        entity.setStatus(order.getStatus());
        OrderEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Order> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    private Order toDomain(OrderEntity entity) {
        return new Order(
            entity.getId(),
            entity.getProductName(),
            entity.getQuantity(),
            entity.getCustomerName(),
            entity.getStatus()
        );
    }
}