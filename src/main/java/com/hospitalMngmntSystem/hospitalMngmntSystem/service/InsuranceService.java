package com.hospitalMngmntSystem.hospitalMngmntSystem.service;

import org.springframework.stereotype.Service;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Insurance;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.InsuranceRepository;
import com.hospitalMngmntSystem.hospitalMngmntSystem.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;

    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Paitent not found with id " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); //for maintaining bidirectional consistency

        return patientRepository.save(patient);
    }

    @Transactional
    public Patient disAssociateInsuranceFromParent(Long patientId){
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + patientId));
        patient.setInsurance(null);
        return patient;
    }

   

}
