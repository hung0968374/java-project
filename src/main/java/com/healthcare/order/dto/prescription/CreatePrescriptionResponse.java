package com.healthcare.order.dto.prescription;


public class CreatePrescriptionResponse {
    private String status;
    private String message;
    private String details;


    private Long patientId;
    private Long doctorId;

    public CreatePrescriptionResponse(String status, String message, String details, Long patientId, Long doctorId) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }
}
