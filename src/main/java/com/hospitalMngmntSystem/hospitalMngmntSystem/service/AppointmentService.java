package com.hospitalMngmntSystem.hospitalMngmntSystem.service;

import org.springframework.stereotype.Service;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Appointment;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Doctor;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.AppointmentRepository;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.DoctorRepository;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
     
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    
    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long patientId , Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null ) throw new IllegalArgumentException("Appointment should not have the id");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);


    }
    @Transactional
    public Appointment reAssignAppointmentToNewDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        //owning side is appointment
        appointment.setDoctor(doctor); //this will automatically update doctor in assign entity because it is dirty.
        doctor.getAppointments().add(appointment); //just for bidirectional
        return appointment;
    }
}
