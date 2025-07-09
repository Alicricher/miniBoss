package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.OrderRequestDto;
import com.example.miniBoss.dto.OrderResponseDto;
import com.example.miniBoss.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity toEntity(OrderRequestDto requestDto);
    OrderResponseDto toResponse(OrderEntity entity);
    void updateEntity(OrderRequestDto requestDto, @MappingTarget OrderEntity targets);
}
