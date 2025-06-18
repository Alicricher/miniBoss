package com.example.miniBoss.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.miniBoss.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    private int id;
    private final List<EmployeeEntity> listOfEmployees = new ArrayList<EmployeeEntity>();

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setId(id);
        listOfEmployees.add(employeeEntity);
        id++;
        return employeeEntity;
    }

    public boolean existByEmail(String email) {
            return listOfEmployees.stream().anyMatch(e -> e.getEmail().equals(email));
    };

    public List<EmployeeEntity> getAllStaff() {
        return listOfEmployees;
    }

    public Optional<EmployeeEntity> getEmployeeById(int id) {
        return listOfEmployees.stream()
                .filter(employeeEntity -> employeeEntity.getId() == id)
                .findFirst();
    }

    public boolean deleteEmployeeById(int id) {
        Optional<EmployeeEntity> employeeOptional = getEmployeeById(id);
        if (employeeOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return  listOfEmployees.remove(employeeOptional.get());
    }

    public EmployeeEntity updateEmployee(int id, EmployeeEntity newEmployeeEntity) {
        Optional<EmployeeEntity> employeeOptional = this.getEmployeeById(id);
        if (employeeOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }
        EmployeeEntity employeeEntity = employeeOptional.get();
        employeeEntity.setName(newEmployeeEntity.getName());
        employeeEntity.setSurname(newEmployeeEntity.getSurname());
        employeeEntity.setEmail(newEmployeeEntity.getEmail());
        employeeEntity.setPassword(newEmployeeEntity.getPassword());
        employeeEntity.setRole(newEmployeeEntity.getRole());
        return employeeEntity;

    }
}
