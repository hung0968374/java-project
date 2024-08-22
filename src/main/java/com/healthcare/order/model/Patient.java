package com.healthcare.order.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "patient")
public class Patient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    private String name;
    private String email;

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Appointment> appointments;
}