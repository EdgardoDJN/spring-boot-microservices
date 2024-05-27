package com.example.customerservice.controller;

import com.example.customerservice.dtos.CustomerServiceDTO;
import com.example.customerservice.dtos.CustomerServiceDTOSave;
import com.example.customerservice.services.CustomerService;
import com.example.customerservice.services.CustomerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CustomerServiceController {

    private final CustomerService customerServiceSerImp;

    public CustomerServiceController(CustomerService customerServiceSerImp) {
        this.customerServiceSerImp = customerServiceSerImp;
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerServiceDTO> saveCustomer(@RequestBody CustomerServiceDTOSave customerServiceDTO) {
        customerServiceSerImp.create(customerServiceDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<CustomerServiceDTO> getCustomer(@PathVariable UUID id) {
        return new ResponseEntity<>(customerServiceSerImp.findById(id), HttpStatus.OK);
    }
}
