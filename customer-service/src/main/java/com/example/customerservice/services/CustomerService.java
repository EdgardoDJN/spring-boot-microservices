package com.example.customerservice.services;

import com.example.customerservice.dtos.CustomerServiceDTO;
import com.example.customerservice.dtos.CustomerServiceDTOSave;

import java.util.UUID;

public interface CustomerService {
    CustomerServiceDTO create(CustomerServiceDTOSave dto);
    CustomerServiceDTO findById(UUID id);
}
