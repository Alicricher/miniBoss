package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeResponseDto mapToResponseDto(EmployeeEntity employeeEntity) {
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
    }
}
