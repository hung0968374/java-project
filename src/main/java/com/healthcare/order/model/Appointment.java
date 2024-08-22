package com.healthcare.order.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @JsonBackReference
    private Doctor doctor;

    private LocalDateTime appointmentTime;

    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }
}