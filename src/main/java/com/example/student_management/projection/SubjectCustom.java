package com.example.student_management.projection;

import com.example.student_management.entity.Subject;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Subject.class)
public interface SubjectCustom {

    Long getId();

    String getName();

    int getGrade();

}
