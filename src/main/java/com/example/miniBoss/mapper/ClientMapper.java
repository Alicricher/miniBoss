package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface ClientMapper {


    ClientEntity toEntity(ClientRequestDto requestDto);
    ClientResponseDto toResponse(ClientEntity entity);
    void updateEntity(ClientRequestDto requestDto, @MappingTarget ClientEntity targets);
}
