package com.example.paymentservice.mapper;

import com.example.paymentservice.dtos.PaymentDTO;
import com.example.paymentservice.dtos.PaymentDTOSave;
import com.example.paymentservice.entities.PaymentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {
    PaymentDTO toDto(PaymentEntity entity);
    PaymentEntity toEntity(PaymentDTOSave dto);
}
