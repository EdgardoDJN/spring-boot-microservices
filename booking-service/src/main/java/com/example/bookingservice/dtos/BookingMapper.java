package com.example.bookingservice.dtos;

import com.example.bookingservice.entities.BookingEntity;

import java.util.UUID;

public class BookingMapper {
    public static BookingEntity toEntity(CreateBookingDto dto, UUID id){
        return BookingEntity.builder()
                .id(id)
                .customerId(dto.getCustomerId())
                .carId(dto.getCarId())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}
