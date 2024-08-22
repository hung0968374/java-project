package com.healthcare.order.service;

import com.healthcare.order.model.Appointment;
import com.healthcare.order.model.Doctor;
import com.healthcare.order.model.Patient;
import com.healthcare.order.repository.AppointmentRepository;
import com.healthcare.order.repository.DoctorRepository;
import com.healthcare.order.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public List<Appointment> getPatientAppointments(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public Appointment createAppointment(Long patientId, Appointment appointment) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (!patientOpt.isPresent()) {
            throw new RuntimeException("Patient not found");
        }

        Optional<Doctor> doctorOpt = doctorRepository.findById(appointment.getDoctor().getId());
        if (!doctorOpt.isPresent()) {
            throw new RuntimeException("Doctor not found");
        }

        appointment.setPatient(patientOpt.get());
        appointment.setDoctor(doctorOpt.get());

        return appointmentRepository.save(appointment);
    }
}