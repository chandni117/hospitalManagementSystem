package com.hospitalMngmntSystem.hospitalMngmntSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Appointment;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Insurance;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.service.AppointmentService;
import com.hospitalMngmntSystem.hospitalMngmntSystem.service.InsuranceService;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {
        // way to create object using @Builder annotation
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient.getInsurance());

        insuranceService.disAssociateInsuranceFromParent(patient.getId());
    }

    @Test
    public void testAppointmentCreation() {

        Appointment appointment = Appointment.builder()
            .appointmentTime(LocalDateTime.of(2025, 10, 12, 14, 30))
            .reason("Sugar")
            .status("Not good")
            .build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 2L,1L);

        appointmentService.reAssignAppointmentToNewDoctor(newAppointment.getId(), 2L);
        
    }


}
