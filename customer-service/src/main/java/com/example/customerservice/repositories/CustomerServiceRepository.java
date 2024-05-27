package com.example.customerservice.repositories;

import com.example.customerservice.entities.CustomerServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerServiceRepository extends JpaRepository<CustomerServiceEntity, UUID> {
}
