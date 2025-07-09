package com.example.miniBoss.dto;

import com.example.miniBoss.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientResponseDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<OrderEntity> orders = new ArrayList<>();
}
