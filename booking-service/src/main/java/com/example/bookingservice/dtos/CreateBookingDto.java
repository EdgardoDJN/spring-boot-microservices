package com.example.bookingservice.dtos;

import com.example.bookingservice.entities.BookingStatus;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class CreateBookingDto {
    public UUID carId;
    public UUID customerId;
    public BookingStatus status;
    public Date startDate;
    public Date endDate;
}
