package edu.uptc.swii.orderservicehexa.interfaces.rest;

import edu.uptc.swii.orderservicehexa.application.services.OrderService;
import edu.uptc.swii.orderservicehexa.domain.model.Order;
import edu.uptc.swii.orderservicehexa.interfaces.rest.dto.CreateOrderRequest;
import edu.uptc.swii.orderservicehexa.interfaces.rest.dto.OrderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        Order order = new Order();
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setCustomerName(request.getCustomerName());
        Order saved = orderService.createOrder(order);
        return toResponse(saved);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        return toResponse(orderService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully!";
    }

    private OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setProductName(order.getProductName());
        response.setQuantity(order.getQuantity());
        response.setCustomerName(order.getCustomerName());
        response.setStatus(order.getStatus());
        return response;
    }
}