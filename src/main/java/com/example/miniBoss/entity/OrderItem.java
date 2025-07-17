package com.example.miniBoss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    private OrderEntity order;

    @ManyToOne(optional = false)
    private ProductEntity product;
    private int quantity;
}
