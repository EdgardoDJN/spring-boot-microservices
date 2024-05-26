package com.example.carinventory.services;

import com.example.carinventory.dtos.CarMapper;
import com.example.carinventory.dtos.CreateCarDto;
import com.example.carinventory.entities.CarEntity;
import com.example.carinventory.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements  CarService{
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public List<CarEntity> listAvailableCar() {
        return carRepository.findAll();
    }

    @Override
    public void reserve(UUID carId) {
        var car = carRepository.findById(carId)
                .orElseThrow();

        car.setAvailable(false);
    }

    @Override
    public void returnCar(UUID carId) {
        var car = carRepository.findById(carId)
                .orElseThrow();

        car.setAvailable(true);
    }

    @Override
    public void addCar(CreateCarDto car) {
        var carEntity = CarMapper.toCarEntity(car, UUID.randomUUID());
        carRepository.save(carEntity);
    }
}

