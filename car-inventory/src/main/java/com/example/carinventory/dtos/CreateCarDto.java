package com.example.carinventory.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreateCarDto {
    private String model;
    private String maker;
}
