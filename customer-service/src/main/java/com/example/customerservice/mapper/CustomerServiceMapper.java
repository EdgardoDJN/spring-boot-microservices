package com.example.customerservice.mapper;

import com.example.customerservice.dtos.CustomerServiceDTO;
import com.example.customerservice.dtos.CustomerServiceDTOSave;
import com.example.customerservice.entities.CustomerServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerServiceMapper {

    CustomerServiceEntity toEntity(CustomerServiceDTOSave dto);
    CustomerServiceDTO toDto(CustomerServiceEntity entity);
}
