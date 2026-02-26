package com.hospitalMngmntSystem.hospitalMngmntSystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    private Long id;

    private LocalDateTime appointmentTime;

    private String reason;

    private String status;

    // @ForeignKey(value = "id")
    // private Patient patientId;

    // private Doctor doctorId;
}
