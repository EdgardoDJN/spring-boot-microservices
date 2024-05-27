package com.example.customerservice.dtos;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerServiceDTO(
        UUID id,
        String name
) {
}
