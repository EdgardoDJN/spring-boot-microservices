package com.example.carinventory.services;

import com.example.carinventory.dtos.CreateCarDto;
import com.example.carinventory.entities.CarEntity;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<CarEntity> listAvailableCar();
    void reserve(UUID carId);
    void returnCar(UUID carId);
    void addCar(CreateCarDto car);
}
