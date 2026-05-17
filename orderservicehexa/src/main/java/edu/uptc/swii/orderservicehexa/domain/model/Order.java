package edu.uptc.swii.orderservicehexa.domain.model;

public class Order {
    private Long id;
    private String productName;
    private Integer quantity;
    private String customerName;
    private String status;

    public Order() {}

    public Order(Long id, String productName, Integer quantity, String customerName, String status) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.customerName = customerName;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}