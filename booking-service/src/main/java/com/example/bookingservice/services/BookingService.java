package com.example.bookingservice.services;

import com.example.bookingservice.dtos.CreateBookingDto;
import com.example.bookingservice.entities.BookingEntity;

import java.util.Optional;
import java.util.UUID;

public interface BookingService {
    void createBooking(CreateBookingDto dto);
    Optional<BookingEntity> findByid(UUID id);
}
