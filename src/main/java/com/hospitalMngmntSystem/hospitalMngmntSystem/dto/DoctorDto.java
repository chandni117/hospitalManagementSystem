package com.hospitalMngmntSystem.hospitalMngmntSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDto {
    private Long id;

    private String name;

    private String specialization;

    private String email;

    private LocalDateTime createdAt;

}
