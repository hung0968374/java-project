package com.healthcare.order.controller;

import com.healthcare.order.model.Appointment;
import com.healthcare.order.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/appointments")
    public Appointment arrangeAppointment(@RequestBody Appointment appointment) {
        return staffService.arrangeAppointment(appointment);
    }

    @PutMapping("/appointment/{appointmentId}")
    public Appointment updateAppointmentPatient(
            @PathVariable Long appointmentId,
            @RequestParam Long newDoctorId) {
        return staffService.updateDoctor(appointmentId, newDoctorId);
    }
}