package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.entity.ClientEntity;
import com.example.miniBoss.entity.OrderEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-09T23:17:29+0500",
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

        clientEntity.setName( requestDto.getName() );
        clientEntity.setSurname( requestDto.getSurname() );
        clientEntity.setEmail( requestDto.getEmail() );
        clientEntity.setPhone( requestDto.getPhone() );

        return clientEntity;
    }

    @Override
    public ClientResponseDto toResponse(ClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClientResponseDto clientResponseDto = new ClientResponseDto();

        clientResponseDto.setName( entity.getName() );
        clientResponseDto.setSurname( entity.getSurname() );
        clientResponseDto.setEmail( entity.getEmail() );
        clientResponseDto.setPhone( entity.getPhone() );
        List<OrderEntity> list = entity.getOrders();
        if ( list != null ) {
            clientResponseDto.setOrders( new ArrayList<OrderEntity>( list ) );
        }

        return clientResponseDto;
    }

    @Override
    public void updateEntity(ClientRequestDto requestDto, ClientEntity targets) {
        if ( requestDto == null ) {
            return;
        }

        targets.setName( requestDto.getName() );
        targets.setSurname( requestDto.getSurname() );
        targets.setEmail( requestDto.getEmail() );
        targets.setPhone( requestDto.getPhone() );
    }
}
