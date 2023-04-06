package com.example.student_management.repository;

import com.example.student_management.entity.Subject;
import com.example.student_management.projection.SubjectCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "subject", collectionResourceRel = "list", excerptProjection = SubjectCustom.class)
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
