package com.hospitalMngmntSystem.hospitalMngmntSystem.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Appointment;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Insurance;
import com.hospitalMngmntSystem.hospitalMngmntSystem.enums.BloogGroupType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private Long id;

    private String name;

    private String gender;

    private LocalDate birthDate;

    private String email;

    private BloogGroupType bloodGroup;

    private LocalDateTime createdAt;

    private Insurance insurance;                //owning side

}
