package com.hospitalMngmntSystem.hospitalMngmntSystem.dto;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Doctor;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Long id;

    private LocalDateTime appointmentTime;

    private String reason;

    private String status;

    private PatientDto patient;

    private DoctorDto doctor;
}
