package com.example.miniBoss.dto;

import com.example.miniBoss.entity.ClientEntity;
import com.example.miniBoss.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private OrderStatus orderStatus;
    private int clientId;
    }

