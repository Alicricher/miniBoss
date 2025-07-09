package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-09T23:17:30+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity toEntity(OrderRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderStatus( requestDto.getOrderStatus() );

        return orderEntity;
    }

    @Override
    public OrderResponseDto toResponse(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        orderResponseDto.setId( entity.getId() );
        orderResponseDto.setDate( entity.getDate() );
        orderResponseDto.setOrderStatus( entity.getOrderStatus() );

        return orderResponseDto;
    }

    @Override
    public void updateEntity(OrderRequestDto requestDto, OrderEntity targets) {
        if ( requestDto == null ) {
            return;
        }

        targets.setOrderStatus( requestDto.getOrderStatus() );
    }
}
