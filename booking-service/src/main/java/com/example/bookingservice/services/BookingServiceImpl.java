package com.example.bookingservice.services;

import com.example.bookingservice.dtos.CreateBookingDto;
import com.example.bookingservice.entities.BookingEntity;
import com.example.bookingservice.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public void createBooking(CreateBookingDto dto){

    }
    public Optional<BookingEntity> findByid(UUID id){
        return bookingRepository.getBookingEntitiesById(id);
    }
}
