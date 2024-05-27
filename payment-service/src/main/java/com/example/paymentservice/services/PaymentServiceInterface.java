package com.example.paymentservice.services;

import com.example.paymentservice.dtos.PaymentDTO;
import com.example.paymentservice.dtos.PaymentDTOSave;

import java.util.UUID;

public interface PaymentServiceInterface {
    PaymentDTO processPayment(PaymentDTOSave payment);
    PaymentDTO getPaymentById(UUID paymentId);
}
