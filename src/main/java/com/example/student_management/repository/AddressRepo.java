package com.example.student_management.repository;

import com.example.student_management.entity.Address;
import com.example.student_management.projection.AddressCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "address", collectionResourceRel = "list", excerptProjection = AddressCustom.class)
public interface AddressRepo extends JpaRepository<Address, Long> {
}
