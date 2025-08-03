package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.entity.ClientEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-03T13:49:59+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientEntity toEntity(ClientRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        return clientEntity;
    }

    @Override
    public ClientResponseDto toResponse(ClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClientResponseDto clientResponseDto = new ClientResponseDto();

        return clientResponseDto;
    }

    @Override
    public void updateEntity(ClientRequestDto requestDto, ClientEntity targets) {
        if ( requestDto == null ) {
            return;
        }
    }
}
