package com.hospitalMngmntSystem.hospitalMngmntSystem.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
     @Id
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable (
        joinColumns = @JoinColumn(name = "dept_id"),
        inverseJoinColumns = @JoinColumn(name = "doctor_id")
)
    private Set<Doctor> doctors = new HashSet<>();
}
