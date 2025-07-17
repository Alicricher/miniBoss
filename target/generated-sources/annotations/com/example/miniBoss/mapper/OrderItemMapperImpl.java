package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.OrderItemResponseDto;
import com.example.miniBoss.entity.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T07:44:41+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemResponseDto toDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();

        return orderItemResponseDto;
    }
}
