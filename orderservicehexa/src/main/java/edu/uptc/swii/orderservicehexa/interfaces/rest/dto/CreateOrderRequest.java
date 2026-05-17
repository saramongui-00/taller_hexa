package edu.uptc.swii.orderservicehexa.interfaces.rest.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private String productName;
    private Integer quantity;
    private String customerName;
}