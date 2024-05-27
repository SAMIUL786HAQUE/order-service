package com.orderservice.order_service.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private  String orderDetails;
    private Long warehouseId;


    private String customerId;

    private String status;

    // Getters and setters
}
