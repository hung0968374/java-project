package com.healthcare.order.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "doctor")
public class Doctor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specialization;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}