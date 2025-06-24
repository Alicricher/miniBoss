package com.example.miniBoss.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {
    MANAGER("Менеджер"),
    EMPLOYEE("Работник");
    private final String displayName;
    private Role(String displayName) {
        this.displayName = displayName;
    }
}
