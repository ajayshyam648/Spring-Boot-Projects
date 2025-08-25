package com.example.hotelmanagement.dtos;

import com.example.hotelmanagement.dtos.enumsDto.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private Long id;

    private RoomType roomType;

    private int roomCount;
}
