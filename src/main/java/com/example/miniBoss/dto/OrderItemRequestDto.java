package com.example.miniBoss.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDto {
    private int productId;
    private int quantity;
}
