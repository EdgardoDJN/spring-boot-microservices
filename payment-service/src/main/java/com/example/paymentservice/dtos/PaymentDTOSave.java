package com.example.paymentservice.dtos;

import com.example.paymentservice.entities.PaymentStatusEnum;
import lombok.Builder;

import java.util.UUID;

@Builder
public record PaymentDTOSave(
        UUID bookingId,
        UUID transactionId,
        long creditCard,
        double amount,
        PaymentStatusEnum status
) {
}
