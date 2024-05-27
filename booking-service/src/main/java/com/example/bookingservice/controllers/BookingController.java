package com.example.bookingservice.controllers;

import com.example.bookingservice.dtos.CreateBookingDto;
import com.example.bookingservice.entities.BookingEntity;
import com.example.bookingservice.rabbitMQ.RabbitMQSender;
import com.example.bookingservice.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class BookingController {

    private final BookingService bookingService;
    private final RabbitMQSender rabbitMQSender;

    public BookingController(BookingService bookingService, RabbitMQSender rabbitMQSender){
        this.bookingService = bookingService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @PostMapping("/booking")
    public ResponseEntity<Void> createBooking(@RequestBody CreateBookingDto dto){
        rabbitMQSender.send(dto.getCarId());
        bookingService.createBooking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<BookingEntity> getBooking(@PathVariable UUID id){
        return bookingService.findByid(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
