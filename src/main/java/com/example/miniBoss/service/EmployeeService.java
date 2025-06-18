package com.example.miniBoss.service;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;
import com.example.miniBoss.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.miniBoss.mapper.EmployeeMapper;

import java.util.List;
import java.util.Optional;

import static com.example.miniBoss.mapper.EmployeeMapper.mapToEntity;
import static com.example.miniBoss.mapper.EmployeeMapper.mapToResponseDto;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        if (employeeRepository.existByEmail(employeeRequestDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (employeeRequestDto.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        EmployeeEntity newEntity = mapToEntity(employeeRequestDto);
        EmployeeEntity employeeEntity = employeeRepository.addEmployee(newEntity);
        return mapToResponseDto(employeeEntity);
    }



    public List<EmployeeResponseDto> getAllStaff() {
        return employeeRepository.getAllStaff().stream()
                .map(EmployeeMapper::mapToResponseDto)
                .toList();
    }

    public EmployeeResponseDto getEmployeeById(int id) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.getEmployeeById(id);

        if (employeeOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return mapToResponseDto(employeeOptional.get());
    }

    public boolean deleteEmployeeById(int id) {
        return employeeRepository.deleteEmployeeById(id);
    }

    public EmployeeResponseDto updateEmployee(int id, EmployeeRequestDto employeeRequestDto) {
        EmployeeEntity newEntity = mapToEntity(employeeRequestDto);
        return mapToResponseDto(employeeRepository.updateEmployee(id, newEntity));
    }
}
