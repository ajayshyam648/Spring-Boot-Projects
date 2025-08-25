package com.example.hotelmanagement.dtos.enumsDto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {
    SINGLE(1),
    DOUBLE(2);

    private final int capacity;

    @JsonCreator
    public static RoomType fromString(String value) {
        return RoomType.valueOf(value.toUpperCase());
    }
}
