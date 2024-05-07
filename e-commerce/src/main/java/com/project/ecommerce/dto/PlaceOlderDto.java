package com.project.ecommerce.dto;

import lombok.Data;

@Data
public class PlaceOlderDto {
    private Long userId;

    private String address;

    private String orderDescription;
}
