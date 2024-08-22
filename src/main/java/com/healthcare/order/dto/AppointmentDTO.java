package com.healthcare.order.dto;

import java.time.LocalDateTime;

public record AppointmentDTO(
        Long appointmentId,
        String doctorName,
        String doctorSpecialization,
        String patientName,
        LocalDateTime appointmentTime
) {
}
