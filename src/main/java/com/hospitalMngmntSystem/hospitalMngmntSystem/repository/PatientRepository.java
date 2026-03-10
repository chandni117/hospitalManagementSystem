package com.hospitalMngmntSystem.hospitalMngmntSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Doctor;
import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{


}
