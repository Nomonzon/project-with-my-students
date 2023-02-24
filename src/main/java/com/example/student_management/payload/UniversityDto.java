package com.example.student_management.payload;

import com.example.student_management.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto {

    private Long id;
    private String name;
    private Long addressId;
}
