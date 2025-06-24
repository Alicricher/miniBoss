package com.example.miniBoss.Controllers;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/staff")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.addEmployee(employeeRequestDto);
    }
    @GetMapping("/staff")
    public List<EmployeeResponseDto> getAllStaff() {
        return employeeService.getAllStaff();
    }

    @GetMapping("/staff/{id}")
    public EmployeeResponseDto getStaff(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/staff/{id}")
    public boolean deleteStaff(@PathVariable int id) {
        return  employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/staff/{id}")
    public EmployeeResponseDto updateStaff(@PathVariable int id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.updateEmployee(id, employeeRequestDto);
    }

}
