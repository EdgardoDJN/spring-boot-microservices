package com.example.customerservice.services;

import com.example.customerservice.dtos.CustomerServiceDTO;
import com.example.customerservice.dtos.CustomerServiceDTOSave;
import com.example.customerservice.entities.CustomerServiceEntity;
import com.example.customerservice.mapper.CustomerServiceMapper;
import com.example.customerservice.repositories.CustomerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImp implements CustomerService {
    private final CustomerServiceRepository serviceRepository;
    private final CustomerServiceMapper mapper;

    public CustomerServiceImp(CustomerServiceRepository serviceRepository, CustomerServiceMapper mapper) {
        this.serviceRepository = serviceRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerServiceDTO create(CustomerServiceDTOSave dto) {
        CustomerServiceEntity entity = mapper.toEntity(dto);
        return mapper.toDto(serviceRepository.save(entity));
    }

    @Override
    public CustomerServiceDTO findById(UUID id) {
        CustomerServiceEntity entity = serviceRepository.findById(id).orElseThrow(RuntimeException::new);
        return mapper.toDto(entity);
    }
}
