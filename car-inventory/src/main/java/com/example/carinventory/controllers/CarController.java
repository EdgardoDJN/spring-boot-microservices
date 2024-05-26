package com.example.carinventory.controllers;

import com.example.carinventory.dtos.CreateCarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.carinventory.entities.CarEntity;
import com.example.carinventory.services.CarService;
import java.util.List;
import java.util.UUID;


@RestController
public class CarController {
    private final CarService service;

    public CarController(CarService service){
        this.service = service;
    }

    @GetMapping(value = "/list-available-car")
    public ResponseEntity<List<CarEntity>> getAllCar(){
        return ResponseEntity.ok(service.listAvailableCar());
    }

    @PutMapping("/reserve")
    public ResponseEntity reserveCar(UUID id){
        service.reserve(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/return")
    public ResponseEntity returnCar(UUID id){
        service.returnCar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add-car")
    public ResponseEntity addCar(@RequestBody CreateCarDto car){
        service.addCar(car);
        return ResponseEntity.ok().build();
    }
}
