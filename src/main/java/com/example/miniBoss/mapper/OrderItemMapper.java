package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.OrderItemResponseDto;
import com.example.miniBoss.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

 /*   @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.price", target = "productPrice")*/
    OrderItemResponseDto toDto(OrderItem orderItem);
}