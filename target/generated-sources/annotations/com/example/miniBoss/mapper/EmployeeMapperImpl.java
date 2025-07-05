package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-05T23:10:37+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity toEntity(EmployeeRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName( dto.getName() );
        employeeEntity.setSurname( dto.getSurname() );
        employeeEntity.setEmail( dto.getEmail() );
        employeeEntity.setPassword( dto.getPassword() );
        employeeEntity.setRole( dto.getRole() );

        return employeeEntity;
    }

    @Override
    public EmployeeResponseDto toResponse(EmployeeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setName( entity.getName() );
        employeeResponseDto.setSurname( entity.getSurname() );
        employeeResponseDto.setEmail( entity.getEmail() );
        if ( entity.getRole() != null ) {
            employeeResponseDto.setRole( entity.getRole().name() );
        }

        return employeeResponseDto;
    }

    @Override
    public void updateEntityFromDto(EmployeeRequestDto dto, EmployeeEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setName( dto.getName() );
        entity.setSurname( dto.getSurname() );
        entity.setEmail( dto.getEmail() );
        entity.setPassword( dto.getPassword() );
        entity.setRole( dto.getRole() );
    }
}
