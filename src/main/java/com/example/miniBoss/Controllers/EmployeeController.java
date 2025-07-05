package com.example.miniBoss.Controllers;

import com.example.miniBoss.dto.EmployeeRequestDto;
import com.example.miniBoss.dto.EmployeeResponseDto;
import com.example.miniBoss.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/staff")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.addEmployee(employeeRequestDto);
    }
    @GetMapping("/staff")
    public Page<EmployeeResponseDto> getAllStaff(Pageable pageable) {
        return employeeService.getAllStaff(pageable);
    }

    @GetMapping("/staff/{id}")
    public EmployeeResponseDto getStaff(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable int id) {
         employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/staff/{id}")
    public EmployeeResponseDto updateStaff(@PathVariable int id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.updateEmployee(id, employeeRequestDto);
    }

}
