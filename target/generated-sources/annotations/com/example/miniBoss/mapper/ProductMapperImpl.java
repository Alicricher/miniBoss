package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.ProductRequestDto;
import com.example.miniBoss.dto.ProductResponseDto;
import com.example.miniBoss.entity.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T07:44:41+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toEntity(ProductRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        return productEntity;
    }

    @Override
    public ProductResponseDto toResponse(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        return productResponseDto;
    }

    @Override
    public void updateEntity(ProductRequestDto requestDto, ProductEntity targets) {
        if ( requestDto == null ) {
            return;
        }
    }
}
