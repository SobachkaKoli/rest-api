package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDto {
    private Long id;
    private String name;
}
