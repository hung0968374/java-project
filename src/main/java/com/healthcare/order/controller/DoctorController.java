package com.healthcare.order.controller;

import com.healthcare.order.dto.AppointmentDTO;
import com.healthcare.order.dto.prescription.CreatePrescriptionRequest;
import com.healthcare.order.dto.prescription.CreatePrescriptionResponse;
import com.healthcare.order.model.Prescription;
import com.healthcare.order.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    // Doctor can see all of his appointments
    @GetMapping("/{id}/appointments")
    public List<AppointmentDTO> getAppointments(@PathVariable Long id,
                                                @RequestParam("date") String date
    ) {
        LocalDateTime startDate = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);

        return doctorService.getDoctorAppointments(id, startDate);
    }

    @PostMapping("/prescriptions")
    public CreatePrescriptionResponse createPrescription(@RequestBody CreatePrescriptionRequest request) {
        Prescription prescription = doctorService.createPrescription(request);

        return new CreatePrescriptionResponse(
                "success",
                "created prescription",
                prescription.getDetails(),
                prescription.getPatient().getId(),
                prescription.getDoctor().getId()
        );
    }

    @GetMapping("/patients/{patientId}/prescriptions")
    public List<Prescription> getPatientPrescriptions(@PathVariable Long patientId) {
        return doctorService.getPatientPrescriptions(patientId);
    }
}