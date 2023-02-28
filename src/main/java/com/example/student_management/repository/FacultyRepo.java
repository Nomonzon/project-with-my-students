package com.example.student_management.repository;

import com.example.student_management.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty,Long> {
}
