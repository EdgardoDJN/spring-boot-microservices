package com.example.bookingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {
    @Id
    public UUID id;
    public UUID carId;
    public UUID customerId;
    @Enumerated(EnumType.ORDINAL)
    public BookingStatus status;
    public Date startDate;
    public Date endDate;
}
