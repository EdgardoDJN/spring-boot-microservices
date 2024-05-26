package com.example.carinventory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class CarEntity {
    @Id
    private UUID id;
    private String model;
    private String maker;
    private Boolean available;
}
