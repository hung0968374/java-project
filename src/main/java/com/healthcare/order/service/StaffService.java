package com.healthcare.order.service;

import com.healthcare.order.model.Appointment;
import com.healthcare.order.model.Doctor;
import com.healthcare.order.repository.AppointmentRepository;
import com.healthcare.order.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment arrangeAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment updateDoctor(Long appointmentId, Long newDoctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        Doctor newDoctor = doctorRepository.findById(newDoctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setDoctor(newDoctor);

        return appointmentRepository.save(appointment);
    }
}