package com.example.miniBoss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();
}
