package com.example.miniBoss.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponseDto {
    private int id;
    private int productId;
    private String productName;
    private int productPrice;
    private int quantity;
}
