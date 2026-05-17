package edu.uptc.swii.orderservicehexa.interfaces.rest.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private String productName;
    private Integer quantity;
    private String customerName;
    private String status;
}