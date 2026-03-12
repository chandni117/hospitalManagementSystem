package com.hospitalMngmntSystem.hospitalMngmntSystem.dto;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;

    private String name;

    private LocalDateTime createdAt;

    private DoctorDto headDoctor;
}
