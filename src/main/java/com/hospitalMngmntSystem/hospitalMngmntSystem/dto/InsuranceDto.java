package com.hospitalMngmntSystem.hospitalMngmntSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {

    private Long id;

    private String policyNumber;

    private String provider;

    private LocalDate validUntil;

    private LocalDateTime createdAt;

    private PatientDto patient;
}
