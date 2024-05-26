package com.example.carinventory.dtos;

import org.springframework.stereotype.Component;
import com.example.carinventory.entities.CarEntity;

import java.util.UUID;

@Component
public class CarMapper {
    public static CreateCarDto toCarDto(CarEntity carEntity) {
        return CreateCarDto.builder()
                .model(carEntity.getModel())
                .maker(carEntity.getMaker())
                .build();
    }

    public static CarEntity toCarEntity(CreateCarDto createCarDto, UUID id) {
        var carEntity = new CarEntity();
        carEntity.setId(id);
        carEntity.setModel(createCarDto.getModel());
        carEntity.setMaker(createCarDto.getMaker());
        carEntity.setAvailable(false);
        return carEntity;
    }

}
