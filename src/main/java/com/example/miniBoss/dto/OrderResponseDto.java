package com.example.miniBoss.dto;

import com.example.miniBoss.entity.ClientEntity;
import com.example.miniBoss.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDto {
    private int id;
    private LocalDateTime date;
    private OrderStatus orderStatus;
    private int clientId;
    private String clientName;
}
