package com.example.carinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class CarInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarInventoryApplication.class, args);
    }

}
