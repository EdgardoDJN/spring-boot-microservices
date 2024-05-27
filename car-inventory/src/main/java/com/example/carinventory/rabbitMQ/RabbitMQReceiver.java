package com.example.carinventory.rabbitMQ;

import com.example.carinventory.services.CarService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.UUID;

@Service
public class RabbitMQReceiver {
    private final CarService carService;

    public RabbitMQReceiver(CarService carService) {
        this.carService = carService;
    }

    public void receiveMessage(String idd) {
        try {
            var id = UUID.fromString(idd);
            carService.reserve(id);
            System.out.println("Car reserved successfully");
        } catch (Exception e) {
            System.out.println("Failed to reserve car");
        }
    }

}
