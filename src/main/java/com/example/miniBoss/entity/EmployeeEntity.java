package com.example.miniBoss.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeEntity {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

}
