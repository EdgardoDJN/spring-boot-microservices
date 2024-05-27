package com.example.paymentservice.services;

import com.example.paymentservice.Exception.EntityNotFoundException;
import com.example.paymentservice.dtos.PaymentDTO;
import com.example.paymentservice.dtos.PaymentDTOSave;
import com.example.paymentservice.entities.PaymentEntity;
import com.example.paymentservice.entities.PaymentStatusEnum;
import com.example.paymentservice.mapper.PaymentMapper;
import com.example.paymentservice.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentServiceInterface {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    public PaymentServiceImpl(PaymentRepository repository, PaymentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PaymentDTO processPayment(PaymentDTOSave payment) {
        var paymentToSave = PaymentDTOSave.builder()
                .transactionId(java.util.UUID.randomUUID())
                .status(PaymentStatusEnum.IN_PROGRESS)
                .amount(payment.amount())
                .bookingId(payment.bookingId())
                .creditCard(payment.creditCard())
                .build();
        var paymentToEntity = mapper.toEntity(paymentToSave);
        return mapper.toDto(repository.save(paymentToEntity));
    }

    @Override
    public PaymentDTO getPaymentById(UUID paymentId) {
        PaymentEntity paymentEntity = repository.findById(paymentId).orElseThrow(() -> new EntityNotFoundException("paymentServiceEntity not found with id: " + paymentId));
        return mapper.toDto(paymentEntity);
    }

}
