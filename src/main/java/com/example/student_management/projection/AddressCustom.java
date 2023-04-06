package com.example.student_management.projection;


import com.example.student_management.entity.Address;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Address.class)
public interface AddressCustom {

    Long getId();
    String getCountry();
    String getRegion();
    String getStreet();
    String getHomeNumber();


}
