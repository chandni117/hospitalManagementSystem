package com.hospitalMngmntSystem.hospitalMngmntSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalMngmntSystem.hospitalMngmntSystem.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
