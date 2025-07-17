package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.ProductRequestDto;
import com.example.miniBoss.dto.ProductResponseDto;
import com.example.miniBoss.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductEntity toEntity(ProductRequestDto requestDto);
    ProductResponseDto toResponse(ProductEntity entity);
    void updateEntity(ProductRequestDto requestDto, @MappingTarget ProductEntity targets);
}
