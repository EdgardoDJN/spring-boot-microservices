package com.example.carservice.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {

    }
}
