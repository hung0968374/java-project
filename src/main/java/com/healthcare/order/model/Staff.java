package com.healthcare.order.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Staff extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
}