package com.example.miniBoss.mapper;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeResponseDto mapToResponseDto(EmployeeEntity employeeEntity) {
        EmployeeResponseDto responseDto = new EmployeeResponseDto();
        responseDto.setInfo(employeeEntity.getName() + "\n" +
                employeeEntity.getSurname() + "\n" +
                employeeEntity.getEmail() + "\n" +
                employeeEntity.getRole());
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
