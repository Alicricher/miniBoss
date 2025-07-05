package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeEntity toEntity(EmployeeRequestDto dto);
    EmployeeResponseDto toResponse(EmployeeEntity entity);
    void updateEntityFromDto(EmployeeRequestDto dto, @MappingTarget EmployeeEntity entity);

}

/*public static EmployeeResponseDto mapToResponseDto(EmployeeEntity employeeEntity) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setName(employeeEntity.getName());
        responseDto.setSurname(employeeEntity.getSurname());
        responseDto.setEmail(employeeEntity.getEmail());
        responseDto.setRole(employeeEntity.getRole().getDisplayName());
        return responseDto;
    }

    public static EmployeeEntity mapToEntity(EmployeeRequestDto requestDto) {
        EmployeeEntity newEntity = new EmployeeEntity();
        newEntity.setName(requestDto.getName());
        newEntity.setSurname(requestDto.getSurname());
        newEntity.setEmail(requestDto.getEmail());
        newEntity.setPassword(requestDto.getPassword());
        newEntity.setRole(requestDto.getRole());
        return newEntity;
    }*/
