package com.example.miniBoss.dto;

import com.example.miniBoss.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    Role role;
}
