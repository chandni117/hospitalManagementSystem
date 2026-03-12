package com.hospitalMngmntSystem.hospitalMngmntSystem.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    @Cacheable("patient")
    public Patient getPatientById(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id"));

        System.out.println(patient);
        return patient;
    }
}
