package com.example.hotelmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomTypeDto {

    SINGLE(1),
    DOUBLE(2);

    private final int capacity;

}
