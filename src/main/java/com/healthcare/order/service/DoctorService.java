package com.healthcare.order.service;

import com.healthcare.order.dto.AppointmentDTO;
import com.healthcare.order.dto.prescription.CreatePrescriptionRequest;
import com.healthcare.order.model.Appointment;
import com.healthcare.order.model.Doctor;
import com.healthcare.order.model.Patient;
import com.healthcare.order.model.Prescription;
import com.healthcare.order.repository.AppointmentRepository;
import com.healthcare.order.repository.DoctorRepository;
import com.healthcare.order.repository.PatientRepository;
import com.healthcare.order.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<AppointmentDTO> getDoctorAppointments(Long doctorId, LocalDateTime startDate) {
        LocalDateTime endDate = startDate.plusDays(1);
        return appointmentRepository.findByDoctorId(doctorId, startDate, endDate);
    }

    @Transactional
    public Prescription createPrescription(CreatePrescriptionRequest request) {
        Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElseThrow(() -> new OpenApiResourceNotFoundException("doctor not found"));
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new OpenApiResourceNotFoundException("patient not found"));
        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setDetails(request.getDetails());

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getPatientPrescriptions(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }
}