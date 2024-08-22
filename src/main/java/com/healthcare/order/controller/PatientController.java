package com.healthcare.order.controller;

import com.healthcare.order.model.Appointment;
import com.healthcare.order.model.Patient;
import com.healthcare.order.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.getAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{id}/appointments")
    public List<Appointment> getAppointments(@PathVariable Long id) {
        return patientService.getPatientAppointments(id);
    }

    @PostMapping(value = "/{id}/appointments", consumes = "application/json")
    public Appointment createAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        return patientService.createAppointment(id, appointment);
    }
}
