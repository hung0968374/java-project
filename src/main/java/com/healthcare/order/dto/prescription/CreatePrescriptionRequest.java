package com.healthcare.order.dto.prescription;

public class CreatePrescriptionRequest {
    private Long doctorId;
    private Long patientId;
    private String details;

    public Long getDoctorId() {
        return doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getDetails() {
        return details;
    }

}
