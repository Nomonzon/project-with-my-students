package com.example.student_management.repository;

import com.example.student_management.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniverRepo extends JpaRepository<University,Long> {
}
