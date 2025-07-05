package com.example.miniBoss.service;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.entity.EmployeeEntity;
import com.example.miniBoss.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.miniBoss.mapper.EmployeeMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto) {
        EmployeeEntity newEntity = employeeMapper.toEntity(employeeRequestDto);
        EmployeeEntity employeeEntity = employeeRepository.save(newEntity);
        return employeeMapper.toResponse(employeeEntity);
    }



    public Page<EmployeeResponseDto> getAllStaff(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(employeeMapper::toResponse);
    }

    public EmployeeResponseDto getEmployeeById(int id) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return employeeMapper.toResponse(employeeOptional.get());
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeResponseDto updateEmployee(int id, EmployeeRequestDto dto) {
        EmployeeEntity existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Сотрудник не найден: " + id));

        employeeMapper.updateEntityFromDto(dto, existing);
        EmployeeEntity updated = employeeRepository.save(existing);

        return employeeMapper.toResponse(updated);
    }
}
