package com.example.bookingservice.repositories;

import com.example.bookingservice.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookingservice.dtos.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, UUID> {
    Optional<BookingEntity> getBookingEntitiesById(UUID id);
    void addBooking(CreateBookingDto booking);
}
