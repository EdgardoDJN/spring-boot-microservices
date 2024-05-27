package com.example.paymentservice.controller;


import com.example.paymentservice.dtos.PaymentDTO;
import com.example.paymentservice.dtos.PaymentDTOSave;
import com.example.paymentservice.services.PaymentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentServiceInterface paymentService;

    public PaymentController(PaymentServiceInterface paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/getPaymentById/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable UUID id){
        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    @PostMapping("/processPayment")
    public ResponseEntity<PaymentDTO>processPayment(@RequestBody PaymentDTOSave dtoSave){
        //paymentService.processPayment(dtoSave);
        return new ResponseEntity<>(paymentService.processPayment(dtoSave), HttpStatus.CREATED);
    }
}
