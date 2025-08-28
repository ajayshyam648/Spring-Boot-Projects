package com.example.hotelmanagement.dtos.enumsDto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {
    SINGLE,
    DOUBLE;

    @JsonCreator
    public static RoomType fromString(String value) {
        return RoomType.valueOf(value.toUpperCase());
    }
}
