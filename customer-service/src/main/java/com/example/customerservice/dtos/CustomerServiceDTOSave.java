package com.example.customerservice.dtos;

import lombok.Builder;

@Builder
public record CustomerServiceDTOSave(
        String name
) {
}
