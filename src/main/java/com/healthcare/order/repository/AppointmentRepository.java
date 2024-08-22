package com.healthcare.order.repository;

import com.healthcare.order.dto.AppointmentDTO;
import com.healthcare.order.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);

    @Query("SELECT new com.healthcare.order.dto.AppointmentDTO(" +
            "a.id, d.name, d.specialization, p.name, a.appointmentTime) " +
            "FROM Appointment a " +
            "JOIN a.doctor d " +
            "JOIN a.patient p " +
            "WHERE d.id = :doctorId " +
            "AND a.appointmentTime >= :startDate " +
            "AND a.appointmentTime < :endDate")
    List<AppointmentDTO> findByDoctorId(Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
}
