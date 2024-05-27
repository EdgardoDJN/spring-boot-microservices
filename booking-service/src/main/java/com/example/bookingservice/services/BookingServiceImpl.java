package com.example.bookingservice.services;

import com.example.bookingservice.dtos.BookingMapper;
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

    @Override
    public void createBooking(CreateBookingDto dto){
        var booking = BookingMapper.toEntity(dto, UUID.randomUUID());
        bookingRepository.save(booking);
    }

    @Override
    public Optional<BookingEntity> findByid(UUID id){
        return bookingRepository.getBookingEntitiesById(id);
    }
}
